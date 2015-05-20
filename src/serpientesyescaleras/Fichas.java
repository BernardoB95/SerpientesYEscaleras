
package serpientesyescaleras;


public class Fichas {
    
    private int Indice;
    protected int posInicial;
    protected int posFinal;
    protected boolean status=false;
    private boolean statusS=false;
    private boolean statusE=false;
    private int posFinalE;
    private int posFinalS;

    
    public Fichas ()
    {
        
    }

    public int getIndice() {
        return Indice;
    }

    public void setIndice(int Indice) {
        this.Indice = Indice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatusS() {
        return statusS;
    }

    public void setStatusS(boolean statusS) {
        this.statusS = statusS;
    }

    public boolean isStatusE() {
        return statusE;
    }

    public void setStatusE(boolean statusE) {
        this.statusE = statusE;
    }

    //Metodos nuevos prueeba
    
    public int getPosFinalE() {
        return posFinalE;
    }

    public void setPosFinalE(int posFinalE) {
        this.posFinalE = posFinalE;
    }

    public int getPosFinalS() {
        return posFinalS;
    }

    public void setPosFinalS(int posFinalS) {
        this.posFinalS = posFinalS;
    }
    
    
    
    

    
}
