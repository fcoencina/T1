import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class Central {
    public Central(){
        zone0 = new ArrayList<Sensor>();
        isArmed = false;
        siren = null;
    }
    public void arm() {
        zona.PirActive();
        isArmed = true;
    }
    public void perimetro(){
        isArmed = true;
    }
    public void disarm() {
        zona.PirDisactive();
        siren.Desactivar();
        isArmed=false;
    }
    public void setZona(Zona zona){this.zona = zona;}
    public void setSiren(Siren s) {siren =s;}
    public void addNewSensor(Sensor s){zone0.add(s);}
    public String getHeader(){return "Central";}
    public int getState(){return isArmed?1:0;}
    
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
    private Zona zona;
}
