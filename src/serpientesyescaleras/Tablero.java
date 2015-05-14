
package serpientesyescaleras;


public class Tablero {
    
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    Fichas ficha = new Fichas();
    int cont = 1;
    
    public void CrearTableroJuego(Fichas[][] Matriz)//Metodo de creacion de tablero
    {
        
        for (int i = 7; i >= 0; i--) //<== Algoritmo de Guille
        {
            if (i%2==0 || i==0) 
            {
                for (int j = 7; j >= 0; j--) 
                {
                   //Matriz[i][j] = ficha.setIndice(cont++);
                }
            }
            else
            {
                for (int j = 0; j < 8; j++) 
                {
                         
                }
            }
            
        }
    }
    
    public void MostrarTablero(Fichas[][] Matriz)//Impresion de tablero, parametro MATRIZ
    {
        System.out.println("            TABLERO");
        CrearTableroJuego(Matriz);
        
        
    }
    
    
}
