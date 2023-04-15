public class MagneticSensor extends Sensor {
    public MagneticSensor(){
        super();
    }
    public void moveMagnetAwayFromSwitch() {
        super.setState(SwitchState.OPEN);
    }
    public void putMagnetNearSwitch() {
        setState(SwitchState.CLOSE);
    }
}
