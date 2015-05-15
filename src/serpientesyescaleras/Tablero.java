
package serpientesyescaleras;


public class Tablero {
    
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    Fichas ficha = new Fichas();
    int cont = 1;
    
    public void CrearTableroJuego(Fichas[][] Matriz)//Metodo de creacion de tablero
    {
        
        for (int j = 7; j >= 0; j--) //<== Algoritmo de Guille
        {
            if (j%2==0 || j==0) 
            {
                for (int i = 7; i >= 0; i--) 
                {
                   [i][j]=cont;
                    //Matriz[i][j] = ficha.setIndice(cont++);
                }
            }
            else
            {
                for (int i = 0; i < 8; i++) 
                {
                         
                }
            }
            
        }
    }
    
    public void MostrarTablero(Fichas[][] Matriz)//Impresion de tablero, parametro MATRIZ
    {
       
        System.out.println("            TABLERO");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                
            }
            
        }
        
        
    }
    
    
}
