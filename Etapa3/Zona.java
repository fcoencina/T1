import java.util.ArrayList;

public class Zona {
    public Zona(float largo, float alto){
        this.largo = largo;
        this.alto = alto;
        pirs = new ArrayList<PIR>();
        personas = new ArrayList<Persona>();
    }
    public void printZona(){
        for(int i=0; i<pirs.size();i++){
            System.out.print("PIR "+i+"\t");
            pirs.get(i).printTodo();
        }
        for(int i=0; i<personas.size();i++){
            System.out.print("Persona "+i+"\t");
            personas.get(i).printPosicion();
        }
    }
    public boolean setPersona(Persona p){
        if(p.getX()<= largo && p.getY()<=alto){
            personas.add(p);
            return true;
        }
        else return false;

    }
    public boolean Mover(int i, char m){
        Persona aux = new Persona(personas.get(i).getX(), personas.get(i).getY());
        aux.Mover(m);
        if(aux.getX()<= largo && aux.getY()<=alto){
            personas.get(i).Mover(m);
            return true;
        }else return false;
    }
    public boolean setPIR(PIR p){
        if(p.getX()<= largo && p.getY()<=alto){

            pirs.add(p);
            return true;
        }
        else return false;

    }
    public void PirDisactive(){
        for(PIR p:pirs){
            p.setState(SwitchState.CLOSE);
        }
    }
    public void PirActive(){
        for(PIR p:pirs){
            p.setState(SwitchState.OPEN);
        }
    }
    public boolean checkZone(){
        boolean salida=false;
        float x,y;
        double hip, a;
        for(int i = 0;i<pirs.size();i++){
            PIR pir = pirs.get(i);
            if(pir.getState()==SwitchState.OPEN){
                for(Persona persona:personas){
                    x = persona.getX();
                    y = persona.getY();
                    x -= pir.getX();
                    y -= pir.getY();
                    hip = Math.sqrt((x*x)+(y*y));
                    if(hip < pir.getRango()){
                        if (x>0){//derecha
                            if(y>0){//arriba
                                //entre 0 y 90
                                a = y/hip;
                                a = Math.asin(a);
                            }else{//abajo
                                //entre 270 y 360
                                a = x/hip;
                                a = Math.asin(a)+1.5*Math.PI;
                            }
                        }else{//izquierda
                            if(y>0){//arriba
                                //entre 90 y 180
                                a = (-1)*x/hip;
                                a = Math.asin(a)+0.5*Math.PI;
                            }else{//abajo
                                //entre 180 y 270
                                a = (-1)*y/hip;
                                a = Math.asin(a)+Math.PI;
                            }
                        }//entre 0 y 2pi
                        a = (a*180)/Math.PI;
                        a = Math.round(a);
                        if (a>=(pir.getAngulo()-(pir.getAmplitud()/2)) && a<=(pir.getAngulo()+(pir.getAmplitud()/2))){
                            System.out.println("Sensor PIR n°"+i+" detectó algo.");
                            salida = true;
                        }

                    }
                }
            }
        }
        return salida;
    }
    private ArrayList<PIR>pirs;
    private ArrayList<Persona>personas;
    private float largo, alto;
}
