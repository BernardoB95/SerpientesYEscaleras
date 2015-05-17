
package serpientesyescaleras;


public class Serpientes extends Fichas
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
    
    
    public void Accion(Fichas Casilla)//Algoritmo no seguro
    {
        Casilla.setIndice(posFinal);
        posInicial = posFinal;
    }

}
