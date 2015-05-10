
package serpientesyescaleras;


public class Tablero {
    
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    
    
    public void CrearTableroJuego(Fichas[][] Matriz)//Metodo de creacion de tablero
    {
        int cont=0;
        for (int i = 7; i >= 0; i--) //<== Algoritmo de Guille
        {
            if (i%2==0 || i==0) 
            {
                for (int j = 7; j >= 0; j--) 
                {
                    System.out.print("\t"+Matriz[i][j]);                   
                }
            }
            else
            {
                for (int j = 0; j < 8; j++) 
                {
                    System.out.print("\t"+Matriz[i][j]);     
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
