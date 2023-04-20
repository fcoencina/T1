import java.util.ArrayList;

public class Central {
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
    public Central(){
        zone0 = new ArrayList<Sensor>();
        isArmed = false;
        siren = null;
    }
    public void arm() {
        //Se refiere a armar la alarma
        isArmed=true;
    }
    public String disarm() {
        //Se refiere a desarmar la alarma
        isArmed=false;
        return "La alarma ha sido desarmada exitosamente";
    }
    public void setSiren(Siren s) {
        siren = s;
    }
    public void addNewSensor(Sensor s){
        zone0.add(s);
    }
    public String getHeader(){
        return "Central";
    }
    public int getState(){
        return isArmed?1:0;
    }
}