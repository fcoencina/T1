public class MagneticSensor extends Sensor {
    public MagneticSensor(){
        super();
    }
    public void moveMagnetAwayFromSwitch() {
        setState(SwitchState.OPEN);
    }
    public void putMagnetNearSwitch() {
        setState(SwitchState.CLOSE);
    }
}
