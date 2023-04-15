public class Door {
    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;

    public Door () {
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        id = nextId++;
    }
    public void open() {
        magneticSensor.moveMagnetAwayFromSwitch();
        setState(State.OPEN);
    }
    public void close() {
        magneticSensor.putMagnetNearSwitch();
        setState(State.CLOSE);
    }
    public String getHeader(){
        return "d"+id;
    }

    public int getState() {
        if (state == State.OPEN)
            return 1;
        else
            return 0;
    }
    public int getId() {
        return id;
    }
    public void setState(State state) {
        this.state = state;
    }

    static {
        nextId = 0;
    }
}
//hola
