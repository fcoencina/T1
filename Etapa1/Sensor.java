    public class Sensor {

    //Constructores___________________________
    public Sensor(){
        this(SwitchState.OPEN);
    }
    public Sensor(SwitchState s){
        state = s;
    }
    //Metodos_________________________________
    public SwitchState getState(){
        return state;
    }
    protected void setState(SwitchState s) {
        state = s;
    }
    public String toString(){
        if (state== SwitchState.CLOSE)
            return "1";
        else
            return "0";
    }
    //Atributos_______________________________
    private SwitchState state;
}
