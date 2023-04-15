import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage3 {
    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private ArrayList<PIR_Detector> pirs;
    private Central central;
    private Siren siren;
    public Stage3() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
    }
    public void readConfiguration(Scanner in){
        // reading <#_doors> <#_windows> <#_PIRs>
        central = new Central();
        int numDoors = in.nextInt();
        for (int i = 0; i < numDoors; i++) {
            Door d = new Door();
            doors.add(d);
            //central....
        }
        int numWindows = in.nextInt();
        for (int i = 0; i < numWindows; i++) {
            Window w = new Window();
            windows.add(w);
            //central....
        }
        int numPIRs = in.nextInt();
        for (int i = 0; i < numPIRs; i++) {
            while (in.hasNextFloat()) {
                Float data = in.nextFloat();
                System.out.println(data);
            }
            while (in.hasNextInt()){
                int data = in.nextInt();
                System.out.println(data);
            }
            //PIR_Detector pir = new PIR_Detector();
            //pirs.add(pir);
            //central....
        }

        in.nextLine();
        String soundFile = in.next();
        siren = new Siren(soundFile);
        central.setSiren(siren);
        in.close();
    }
    public void executeUserInteraction (Scanner in, PrintStream out){
        String command;
        char parameter;
        int i;
        int step=0;
        printHeader(out);
        while (true) {
            printState(step++, out);
            siren.stop();
            command = in.next();
            if (command.charAt(0)=='x') break;
            switch (command.charAt(0)) {
                case 'd':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter == 'o'){
                        doors.get(i).open();
                        if (central.getState() == 1)
                            siren.play();
                    }
                    else
                        doors.get(i).close();
                    break;
                case 'w':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter == 'o') {
                        windows.get(i).open();
                        if (central.getState() == 1)
                            siren.play();
                    }
                    else
                        windows.get(i).close();
                    break;
                case 'k':
                    parameter = in.next().charAt(0);
                    int open = 0;
                    switch (parameter) {
                        case 'a':
                            break;
                        case 'p':
                            if (doors.get(0).getState() == 1) {
                                System.out.println("Zona 0 se encuentra abierta");
                                open = 1;
                            }

                            for (Door door : doors) {
                                if ((doors.get(0) != door) && (door.getState() == 1)){
                                    System.out.println("Zona 1 se encuentra abierta");
                                    open = 1;
                                }
                            }

                            for (Window window : windows) {
                                if (window.getState() == 1){
                                    System.out.println("Zona 1 se encuentra abierta");
                                    open = 1;
                                }
                            }

                            if (open == 0){
                                System.out.println(central.arm());
                            }
                            break;
                        case 'd':
                            System.out.println(central.disarm());
                            break;
                    }
            }
            central.checkZone();
        }
    }
    public void printHeader(PrintStream out){
        out.print("Step");
        for (Door door : doors) out.print("\t" + door.getHeader());
        for (Window window : windows) out.print("\t" + window.getHeader());
        out.print("\t" + siren.getHeader());
        out.print("\t" + central.getHeader());
        out.println();
    }
    public void printState(int step, PrintStream out){
        out.print(step);
        for (Door door : doors) out.print("\t" + door.getState());
        for (Window window : windows) out.print("\t" + window.getState());
        out.print("\t" + siren.getState());
        out.print("\t" + central.getState());
        out.println();
    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        //System.out.println("File: " + args[0]);
        Stage3 stage = new Stage3();
        stage.readConfiguration(in);
        //stage.executeUserInteraction(new Scanner(System.in), new PrintStream("output.csv"));
    }
}
