public class Door {
    public Door () {
        magneticSensor = new MagneticSensor();
        magneticSensor.setState(SwitchState.CLOSE);
        state = State.CLOSE;
        id = nextId++;
    }
    public void open() {
        state = State.OPEN;
    }
    public void close() {
        state = State.CLOSE;
    }
    public String getHeader(){
        return "d"+id;
    }
    public int getState(){
        if (state == State.CLOSE){
            return 1;
        }else{
            return 0;
        }
    }

    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}