
package serpientesyescaleras;


public class Escaleras extends Fichas
{
    private int indiceE;//Indice piso escalera
    private int indiceEf;//Indice tope escalera
    
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

    public int getIndiceE() {
        return indiceE;
    }

    public void setIndiceE(int indiceE) {
        this.indiceE = indiceE;
    }

    public int getIndiceEf() {
        return indiceEf;
    }

    public void setIndiceEf(int indiceEf) {
        this.indiceEf = indiceEf;
    }
    
//    public void Accion(Fichas Casilla)//No estoy seguro del algoritmo(Teorico)
//    {
//         Casilla.setIndice(posFinal);
//         posInicial = posFinal;
//    }
}
