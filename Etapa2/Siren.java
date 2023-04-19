import java.io.File;
import java.net.URL;

public class Siren {
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
    public Siren (String soundFileName){
        try {
            dir = new File(soundFileName).toURI().toURL();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
        isSounding = false;
    }
    public void play(){
        isSounding = true;
        aWave = new AePlayWave(dir);
        aWave.start();
        try{
            System.out.println("Alarm is Sounding!");
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Ha ocurrido un problema con el thread");
        }
    }
    public void stop(){
        if (isSounding){
            isSounding = false;
            aWave.stopSounding();
        }
    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() {
        if (isSounding)
            return 1;
        else
            return 0;
    }
}
