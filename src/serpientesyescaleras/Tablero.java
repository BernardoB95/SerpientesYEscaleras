
package serpientesyescaleras;


public class Tablero {
    
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    
    int cont = 1;
    
   
    
    public void CrearTableroJuego()//Metodo de creacion de tablero
    {
       
       
        for (int i = 7; i >= 0; i--) //<== Algoritmo de Guille
        {
            
            if (i%2==0 || i==0) 
            {
                for (int j = 7; j >= 0; j--) 
                {
                   Fichas Casilla = new Fichas();//Faltaba crear los 64 objetos
                    Casilla.setIndice(cont);
                    Matriz[i][j]=Casilla; 

                    cont++;
                    
                }
            }
            else
            {
                for (int j = 0; j < 8; j++) 
                {
                    Fichas Casilla = new Fichas(); //Faltaba crear los 64 objetos
                    Casilla.setIndice(cont); 
                    Matriz[i][j]=Casilla;
                    cont++;
                }
            }
        } 

    }
    
    public void MostrarTablero(Jugadores jugador)//Impresion de tablero, parametro MATRIZ
    {
        int pos = jugador.Accion(jugador.LanzarDado());
        
        System.out.println("                     TABLERO");
        for (int i = 0; i < 8; i++)
        {
            System.out.println("");
            for (int j = 0; j < 8; j++)
            {
                if(Matriz[i][j].getIndice() == pos)
                {
                    System.out.print("[X]\t");
                }else{
                    System.out.print("["+Matriz[i][j].getIndice()+"]"+"\t");  
                }
            }
        }       
            
            
        
        
    }
    
    
}
