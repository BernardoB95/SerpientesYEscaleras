
package serpientesyescaleras;

import java.util.Random;
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
    
    public void CantidadJugadores()
    {
        Tablero tab = new Tablero();
        int selec = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cuantos jugadores van a ser ingresados? 2-4");
        
        selec = sc.nextInt();
        switch(selec)
        {              
            case 2:
                Jugadores jug = new Jugadores();
                Jugadores jug2 = new Jugadores();   
                
                
                tab.CrearTableroJuego();
                jug.Accion(jug.LanzarDado());
                tab.MostrarTablero();   // <- revisar metodo
            break;
                
            case 3:
                Jugadores jug3 = new Jugadores();
                
            break;
                
            case 4:
                Jugadores jug4 = new Jugadores();
            break;
                
            default:
                System.out.println("Numero invalido ingresado. Vuelva a ingresarlo por favor");
            break;
                
        }
    }
    
    public static void main(String[] args) 
    {
//        SerpientesYEscaleras sye = new SerpientesYEscaleras();
//        sye.CantidadJugadores();
        
        
        
       Tablero tab = new Tablero();
       tab.CrearTableroJuego();
       tab.MostrarTablero();

        
    }
    
}
