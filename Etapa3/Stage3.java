import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage3 {
    public Stage3() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
        pirs = new ArrayList<PIR>();
        zona = new Zona(10,10);
    }
    public void readConfiguration(Scanner in){
        // reading <#_doors> <#_windows> <#_PIRs>
        central = new Central();
        int numDoors = in.nextInt();
        for (int i = 0; i < numDoors; i++) {
            Door d = new Door();
            doors.add(d);
            if(d.getState()==1){
                Sensor s = new Sensor(SwitchState.CLOSE);
                central.addNewSensor(s);
            }else{
                Sensor s = new Sensor();
                central.addNewSensor(s);
            }
        }
        int numWindows = in.nextInt();
        for (int i = 0; i < numWindows; i++) {
            Window w = new Window();
            windows.add(w);
            if(w.getState()==1){
                Sensor s = new Sensor(SwitchState.CLOSE);
                central.addNewSensor(s);
            }else{
                Sensor s = new Sensor();
                central.addNewSensor(s);
            }
        }
        int numPirs = in.nextInt();
        in.nextLine();
        for(int i=0; i<numPirs;i++){
            Float x = in.nextFloat();
            Float y = in.nextFloat();
            int angulo = in.nextInt();
            int amplitud = in.nextInt();
            int rango = in.nextInt();
            PIR pir = new PIR(x,y,angulo,amplitud,rango);
            pirs.add(pir);
            zona.setPIR(pir);
        }
        in.nextLine();
        String soundFile = in.next();
        siren = new Siren(soundFile);
        central.setSiren(siren);
        central.setZona(zona);
        in.close();
    }
    public void executeUserInteraction (Scanner in, PrintStream out){
        String command;
        char parameter;
        int i, sum;
        int step=0;
        printHeader(out);
        while (true) {
            printState(step++, out);
            siren.Desactivar();
            command = in.next();
            if (command.charAt(0)=='x') break;
            switch (command.charAt(0)) {
                case 'd':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter== 'o'){
                        if(doors.get(i).getState()==1){
                            doors.get(i).open();
                            if(central.getState()==1){
                                siren.play();
                                siren.stop();
                            }
                        }else System.out.println("La puerta "+i+" ya está abierta.");
                    }else
                        doors.get(i).close();
                    break;
                case 'w':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter== 'o'){
                        if(windows.get(i).getState()==1){
                            windows.get(i).open();
                            if(central.getState()==1){
                                siren.play();
                                siren.stop();
                            }
                        }else System.out.println("La ventana "+i+" ya está abierta.");
                    }else
                        windows.get(i).close();
                    break;
                case 'k':
                    parameter = in.next().charAt(0);
                    boolean listo = true;
                    switch (parameter) {
                        case 'a':
                            //Zona 0
                            if (doors.get(0).getState()==0){
                                System.out.println("Zona 0 abierta.");
                                listo = false;
                                }
                            //Zona 1
                            sum=0;
                            //Puertas
                            for(i=1;i<doors.size();i++){
                                if(doors.get(i).getState()==0) sum++;
                            }
                            //Ventanas
                            for(Window w: windows) {
                                if(w.getState()==0) sum++;
                            }
                            if (sum>0){
                                System.out.println("Zona 1 abierta.");
                                listo= false;
                            }
                            //Zona 2
                            if (listo == true){
                                central.arm();
                                System.out.println("Alarma armada.");
                            }
                            break;
                            break;
                        case 'd':
                            central.disarm();
                            System.out.println("La alarma fue desarmada.");
                            break;
                    }
                    break;
                case 'c':
                    Float x = in.nextFloat();
                    Float y = in.nextFloat();
                    Persona persona = new Persona(x, y);
                    if (zona.setPersona(persona)==true) System.out.println("Persona agregada con exito.");
                    else System.out.println("No se puede agregar a la persona en estas coordenadas de la Zona.");
                    break;
                case 'p':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    zona.Mover(i, parameter);
                    break;
                case 's':
                    zona.printZona();
                    break;
            }
            if(zona.checkZone()==true){
                siren.play();
                siren.stop();
            }
        }
    }
    public void printHeader(PrintStream out){
        out.print("Step");
        for (int i=0; i < doors.size(); i++)
            out.print("\t"+doors.get(i).getHeader());
        for (int i=0; i < windows.size(); i++)
            out.print("\t"+windows.get(i).getHeader());
        for (int i=0; i < pirs.size(); i++)
            out.print("\t"+pirs.get(i).getHeader());
        out.print("\t"+central.getHeader());
        out.print("\t"+siren.getHeader());
        out.println();
    }
    public void printState(int step, PrintStream out){
        out.print(step);
        for(Door d: doors) out.print("\t"+d.getState());
        for(Window w: windows) out.print("\t"+w.getState());
        for(PIR p:pirs) out.print("\t"+p.getState());
        out.print("\t"+central.getState());
        out.print("\t"+siren.getState());
        out.println();
    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage3 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        System.out.println("File: " + args[0]);
        Stage3 stage = new Stage3();
        stage.readConfiguration(in);
        stage.executeUserInteraction(new Scanner(System.in), new PrintStream(new File("output.csv")));
    }

    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private ArrayList<PIR> pirs;
    private Central central;
    private Siren siren;
    private Zona zona;
}
