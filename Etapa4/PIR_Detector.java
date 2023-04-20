public class PIR_Detector extends Sensor{
    private float x;
    private float y;
    private int direction_angle;
    private int sensing_angle;
    private int sensing_range;
    private final int id;
    private static int nextId = 0;

    
    /*
    * Constructor del Sensor PIR, creandolo con todos sus parámetros.
    * @param {float} x Coordenada en el eje x del sensor PIR
    * @param {float} y Coordenada en el eje y del sensor PIR
    * @param {int} direction_angle Ángulo de dirección del sensor PIR
    * @param {int} sensing_angle Ángulo de visión del sensor PIR
    * @param {int} sensing_range Rango de visión del sensor PIR
    */
    public PIR_Detector(float x, float y, int direction_angle, int sensing_angle, int sensing_range){
        this.x = x;
        this.y = y;
        this.direction_angle = direction_angle;
        this.sensing_angle = sensing_angle;
        this.sensing_range = sensing_range;
        id = nextId++;
        super.setState(SwitchState.CLOSE);
    }
    
    /*
    * Obtiene el Ángulo dirección del sensor PIR.
    * @return {int} el ángulo de dirección
    */
    public int getDirection_angle() {
        return direction_angle;
    }
    
    /*
    * Obtiene la coordenada en el eje x del sensor PIR.
    * @return {float} la coordenada en el eje x
    */
    public float getX() {
        return x;
    }
    
    /*
    * Obtiene la coordenada en el eje y del sensor PIR.
    * @return {float} la coordenada en el eje y
    */
    public float getY() {
        return y;
    }
    
    /*
    * Obtiene el header del sensor PIR.
    * @return {String} "'Pir'+ el identificador del sensor"
    */
    public String getHeader(){
        return "Pir"+id;
    }
    
    /*
    * Obtiene rango de visión del sensor PIR, a través del teorema de pitágoras y detecta si la persona está en el rango abriendo el sensor.
    * @param {float} pir_x posición en el eje x del sensor
    * @param {float} pir_y posición en el eje y del sensor
    * @param {float} x posición en el eje x de la persona
    * @param {float} y posición en el eje y de la persona
    */
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
