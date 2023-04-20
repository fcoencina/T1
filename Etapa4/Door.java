public class Door {
    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;

    /*
    * Constructor de la puerta con sensor margnético y cerrada.
    */
    public Door () {
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        id = nextId++;
    }
    
    /*
    * Setea el estado de la puerta a abierto.
    */
    public void open() {
        magneticSensor.moveMagnetAwayFromSwitch();
        setState(State.OPEN);
    }
    
    /*
    * Setea el estado de la puerta a cerrado.
    */
    public void close() {
        magneticSensor.putMagnetNearSwitch();
        setState(State.CLOSE);
    }
    
    /*
    * obtiene el header de la puerta.
    * @return {String} "'d'+el identificador de la puerta"
    */
    public String getHeader(){
        return "d"+id;
    }
    
    /*
    * obtiene el estado de la puerta, que puede estar abierta o cerrada.
    * @return 1 si esta abierta, 0 en caso contrario
    */
    public int getState() {
        if (state == State.OPEN)
            return 1;
        else
            return 0;
    }
    
    /*
    * obtiene el identificador de la puerta.
    * @return {int} identificador de la puerta
    */
    public int getId() {
        return id;
    }
    
    /*
    * Setea el estado de la puerta.
    */
    public void setState(State state) {
        this.state = state;
    }

    static {
        nextId = 0;
    }
}

