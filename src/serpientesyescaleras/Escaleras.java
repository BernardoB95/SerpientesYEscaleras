
package serpientesyescaleras;


public class Escaleras extends Fichas
{

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
    
    
    public void Accion(Fichas Casilla)//No estoy seguro del algoritmo(Teorico)
    {
         Casilla.setIndice(posFinal);
         posInicial = posFinal;
    }
    
}
