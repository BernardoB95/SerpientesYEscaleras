
package serpientesyescaleras;


public class Serpientes extends Fichas
{
    
    private int indiceS;
    private int indiceSf;

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

    public int getIndiceS() {
        return indiceS;
    }

    public void setIndiceS(int indiceS) {
        this.indiceS = indiceS;
    }

    public int getIndiceSf() {
        return indiceSf;
    }

    public void setIndiceSf(int indiceSf) {
        this.indiceSf = indiceSf;
    }
    
    

    public void Accion(Jugadores Jugador)//Algoritmo no seguro
    {
        Jugador.setPosFinal(indiceSf);
        Jugador.setPosInicial(indiceSf);
//        Casilla.setIndice(posFinal);
//        posInicial = posFinal;
    }
}
