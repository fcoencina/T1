public class MagneticSensor extends Sensor {
    
    /*
    *Obtiene el método superior.
    */
    public MagneticSensor(){
        super();
    }
    
    /*
    *Llama al metodo que setea el estado del sensor a abierto.
    */
    public void moveMagnetAwayFromSwitch() {
        setState(SwitchState.OPEN);
    }
    
    /*
    *Llama al metodo que setea el estado del sensor a cerrado.
    */
    public void putMagnetNearSwitch() {
        setState(SwitchState.CLOSE);
    }
}
