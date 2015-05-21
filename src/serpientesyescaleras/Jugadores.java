
package serpientesyescaleras;

import java.util.Random;


public class Jugadores extends Fichas
{
    //Atributo
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
    public Jugadores(){
        
    }
    
    //Metodos
    public int LanzarDado()//Metodo random dado 1-6
    {
        int random = 0;
        Random rd = new Random();
        
        random = rd.nextInt(6)+1;
        return random;
        
    }
    
    public int Accion(int random)//Metodo de movimiento con indices. Recibe LanzarDado por parametro
    {
        int acum = 0;        

        posFinal = posInicial + random;
        acum = posFinal;
        posInicial = posFinal;
        
        return posFinal;
    }
    
}
