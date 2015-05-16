
package serpientesyescaleras;

import java.util.Scanner;


public class SerpientesYEscaleras {

    
    public int Menu()
    {
        System.out.println("            SERPIENTES Y ESCALERAS");
        System.out.println("====================================================");
        System.out.println("[1] Jugar\n"
                           +"[2] Highscores\n"
                           +"[3] Instrucciones\n");
        int resp=0;
        Scanner sc = new Scanner(System.in);
        return resp = sc.nextInt();
    }
    
    public void Juego(int Menu)
    {
        switch(Menu)
        {
            case 1: 
                break;
                
            case 2:
                break;
              
            case 3:
                break;
        }
    }
    
    public static void main(String[] args) 
    {
       Tablero tab = new Tablero();
       tab.CrearTableroJuego();
       tab.MostrarTablero();
       
        
        
    }
    
}
