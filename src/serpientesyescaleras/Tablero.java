
package serpientesyescaleras;


public class Tablero {
    
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    
    int cont = 1;
    
   
    
    public void CrearTableroJuego()//Metodo de creacion de tablero
    {
       
       
        for (int i = 7; i >= 0; i--) //<== Algoritmo de Guille
        {
            Fichas Casilla = new Fichas();
            if (i%2==0 || i==0) 
            {
                for (int j = 7; j >= 0; j--) 
                {
                   
                    Casilla.setIndice(cont);
                    Matriz[i][j]=Casilla; 
                    //System.out.print(cont+"\t");
//                    System.out.print(Matriz[i][j].getIndice()+"\t");
                    cont++;
                    
                }
            }
            else
            {
                for (int j = 0; j < 8; j++) 
                {
                     
                    Casilla.setIndice(cont); 
                    Matriz[i][j]=Casilla;
                    //System.out.print(cont +"\t");
//                    System.out.print(Matriz[i][j].getIndice()+"\t");
                    cont++;
                }
            }
        } 
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Matriz[i][j].getIndice()+"\t");
            }
        }
    }
    
    public void MostrarTablero()//Impresion de tablero, parametro MATRIZ
    {
        
        System.out.println("                TABLERO");
        for (int i = 0; i < 8; i++)
        {
            System.out.println("");
            for (int j = 0; j < 8; j++)
            {
                System.out.print(Matriz[i][j].getIndice()+"\t");
            }
        }       
            
            
        
        
    }
    
    
}
