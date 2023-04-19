public class Sensor {
    private SwitchState state;
    public Sensor(){
        this(SwitchState.OPEN);
    }
    public Sensor(SwitchState s){
        state = s;
    }
    public int getState(){
        if (state == SwitchState.OPEN)
            return 1;
        else
            return 0;
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
}
