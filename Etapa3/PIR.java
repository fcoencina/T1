public class PIR extends Sensor{
    public PIR(float x, float y, int angulo, int amplitud, int rango){
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.amplitud = amplitud;
        this.rango = rango;
        state = SwitchState.CLOSE;
        id = nextId++;
    }
    public void setState(SwitchState s){
        state = s;
    }
    public float getX(){return x;}
    public float getY(){return y;}
    public int getRango(){return rango;}
    public int getAngulo(){return angulo;}
    public int getAmplitud(){return amplitud;}
    public String getHeader(){return "Pir"+id;}
    public void printTodo(){
        System.out.println("State: "+state+"\tx: "+x+"\ty: "+y+"\tangulo: "+angulo+"\tamplitud: "+amplitud+"\trango: "+rango);
    }

    private float x, y;
    private int angulo, amplitud, rango;
    private final int id;
    private static int nextId;
    static{
        nextId = 0;
    }
}
