public class PIR_Detector extends Sensor{
    private float x;
    private float y;
    private int direction_angle;
    private int sensing_angle;
    private int sensing_range;
    private final int id;
    private static int nextId = 0;

    public PIR_Detector(float x, float y, int direction_angle, int sensing_angle, int sensing_range){
        this.x = x;
        this.y = y;
        this.direction_angle = direction_angle;
        this.sensing_angle = sensing_angle;
        this.sensing_range = sensing_range;
        id = nextId++;
        super.setState(SwitchState.CLOSE);
    }
    public int getDirection_angle() {
        return direction_angle;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public String getHeader(){
        return "Pir"+id;
    }
    public int deteccion(float pir_x, float pir_y, float x, float y) {
        Double range = Math.sqrt(Math.pow((pir_x - x), 2) + Math.pow((pir_y - y), 2));
        if (range <= (double)sensing_range) {
            setState(SwitchState.OPEN);
            return 1;
        }
        else
            return 0;
    }
}
