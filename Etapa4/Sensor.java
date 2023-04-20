public class Sensor {
    private SwitchState state;
    
    /*
    * Setea el estado del sensor a abierto.
    */
    public Sensor(){
        this(SwitchState.OPEN);
    }
    
    /*
    * Cambia el estado la sirena.
    */
    public Sensor(SwitchState s){
        state = s;
    }
    
    /*
    * Obtiene el estado de la sirena.
    * @return 1 si está abierta la sirena y 0 en caso contrario
    */
    public int getState(){
        if (state == SwitchState.OPEN)
            return 1;
        else
            return 0;
    }
    
    /*
    * Cambia el estado la sirena.
    */
    protected void setState(SwitchState s) {
        state = s;
    }
    
    /*
    * Obtiene el estado de la sirena.
    * @return 1 si está cerrada la sirena y 0 en caso contrario
    */
    public String toString(){
        if (state== SwitchState.CLOSE)
            return "1";
        else
            return "0";
    }
}
