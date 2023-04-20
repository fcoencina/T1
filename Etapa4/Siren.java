import java.io.File;
import java.net.URL;

public class Siren {
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
    
   /*
   * Obtener y guardar la sirena.
   * @param soundFileName Es el nombre del archivo de sonido para la alarma con extensión wav
   */
    public Siren (String soundFileName){
        try {
            dir = new File(soundFileName).toURI().toURL();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
        isSounding = false;
    }
    
    /*
    * Pone a sonar la alarma.
    */
    public void play(){
        isSounding = true;
        aWave = new AePlayWave(dir);
        aWave.start();
        try{
            System.out.println("Alarm is sounding!");
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Ha ocurrido un problema con el thread");
        }
    }
    
    /*
    * Detiene el sonido de la alarma.
    */
    public void stop(){
        if (isSounding){
            isSounding = false;
            aWave.stopSounding();
        }
    }
    
    /*
    * Obtiene el header de la sirena.
    */
    public String getHeader() {
        return "Siren";
    }
    
    /*
    * Obtiene el estado de la sirena.
    */
    public int getState() {
        if (isSounding)
            return 1;
        else
            return 0;
    }
}
