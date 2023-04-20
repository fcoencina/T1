import java.util.ArrayList;

public class Central {
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
    
    /*
    * Constructor de la centrar con la alarma no armada y sin sirena.
    */
    public Central(){
        zone0 = new ArrayList<Sensor>();
        isArmed = false;
        siren = null;
    }
    
    /*
    * Arma la alarma.
    */
    public void arm() {
        isArmed=true;
    }
    
    /*
    * Desarma la alarma.
    */
    public String disarm() {
        isArmed=false;
        return "La alarma ha sido desarmada exitosamente";
    }
    
    /*
    * Setea la alarma.
    */
    public void setSiren(Siren s) {
        siren = s;
    }
    
    /*
    * Agrega un nuevo sensor.
    * @param s sensor nuevo a agregar
    */
    public void addNewSensor(Sensor s){
        zone0.add(s);
    }
    
    /*
    * Obtiene el header de la central, el cual en general es 'Central'.
    * @return {String} El header común de central
    */
    public String getHeader(){
        return "Central";
    }
    
    /*
    * Obtiene el estado de la alarma.
    * @return 1 si la alarma está armada, 0 en caso contrario
    */
    public int getState(){
        return isArmed?1:0;
    }
}
