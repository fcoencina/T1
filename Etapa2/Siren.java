import java.io.File;
import java.net.URL;

public class Siren {
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
        aWave= new AePlayWave(dir);
        aWave.start();
        try{
            Thread.sleep(3000);
        }
        catch (Exception e){
            System.out.println("Ha ocurrido un problema con el thread");
        }
    }
    
    public void stop(){
        aWave.stopSounding();
    }
    public String getHeader() {
        return "Siren";
    }
    public void Desactivar(){
        isSounding = false;
    }

    public int getState() {
        return isSounding?1:0;
    }
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
