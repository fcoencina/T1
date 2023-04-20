public class Person {
    private float x;
    private float y;

    /*
    * Setea las coordenas de la persona.
    * @param x {float} coordenada en el eje x de la persona
    * @param y {float} coordenada en el eje y de la persona
    */
    public Person(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    /*
    * Obtiene la coordenada en el eje x de la persona 
    * @return {float} la coordenada de la persona en el eje x
    */
    public float getX() {
        return x;
    }
    
    /*
    * Obtiene la coordenada en el eje x de la persona 
    * @return {float} la coordenada de la persona en el eje x
    */
    public float getY() {
        return y;
    }
    
    
    /*
    * Setea la coordenada en el eje x de la persona 
    * @param x {float} coordenada de la persona en el eje x
    */
    public void setX(float x) {
        this.x = x;
    }
    
    /*
    * Setea la coordenada en el eje y de la persona 
    * @param y {float} coordenada de la persona en el eje y
    */
    public void setY(float y) {
        this.y = y;
    }
}
