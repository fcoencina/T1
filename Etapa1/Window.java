public class Window {
    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId = 0;
    public Window() {
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        id = nextId++;
    }
    public void open() {
        setState(State.OPEN);
    }
    public void close() {
        setState(State.CLOSE);
    }
    public String getHeader(){
        return "w"+id;
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
}
