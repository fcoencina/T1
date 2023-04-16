public class PIR_Detector extends Sensor{
    private float x;
    private float y;
    private int direction_angle;
    private int sensing_angle;
    private int sensing_range;

    public PIR_Detector(float x, float y, int direction_angle, int sensing_angle, int sensing_range){
        this.x = x;
        this.y = y;
        this.direction_angle = direction_angle;
        this.sensing_angle = sensing_angle;
        this.sensing_range = sensing_range;
    }

    public int getDirection_angle() {
        return direction_angle;
    }
}
