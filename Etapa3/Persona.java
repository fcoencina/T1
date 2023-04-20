public class Persona {
    public Persona(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void Mover(char m){
        if(m=='w') y+=(0.5);
        else if(m=='s')y-=(0.5);
        else if(m=='a')x-=(0.5);
        else if(m=='d')x+=(0.5);
    }
    public void printPosicion(){
        System.out.println("x: "+x+"\ty:"+y);
    }
    private float x, y;
}
