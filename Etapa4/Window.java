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
    
    /*
    * Setea el estado del objeto ventana en abierto.
    */
    public void open() {
        magneticSensor.moveMagnetAwayFromSwitch();
        setState(State.OPEN);
    }
    
    /*
    * Setea el estado del objeto ventana en cerrado.
    */
    public void close() {
        magneticSensor.putMagnetNearSwitch();
        setState(State.CLOSE);
    }
   
    /*
    * Obtiene el header de la ventana 
    * @return Un String con el indicar de ventana 'w' junto a su header correspondiente
    */
    public String getHeader(){
        return "w"+id;
    }
    
    /*
    * Obtiene el estado de la ventana, si está abierta o cerrada.
    * @return un 1 si la ventana está abierta y un 0 si la ventana está cerrada
    */
    public int getState() {
        if (state == State.OPEN)
            return 1;
        else
            return 0;
    }
    /*
    * Obtiene el identificador de la ventana.
    * @return el identificador de la ventana
    */
    public int getId() {
        return id;
    }
    
    /*
    * Setea el estado de la venata.
    */
    public void setState(State state) {
        this.state = state;
    }
}
