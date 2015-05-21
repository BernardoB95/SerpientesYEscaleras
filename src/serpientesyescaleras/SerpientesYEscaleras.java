
package serpientesyescaleras;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class SerpientesYEscaleras {

    public static Scanner sc = new Scanner(System.in);
    
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
    
    public void Juego(int Menu) throws IOException
    {
        switch(Menu)
        {
            case 1: 
//                int num = 0;
//                do
//                {
//                    System.out.println("Modalidades de juego [1]Easy  [2]Hard");
//                    num = sc.nextInt();
//                    if(num!=1 && num!=2)
//                        System.out.println("El numero ingresado es invalido");
//                }
//                while(num!=1 && num!=2);
//                tab.TipoJuego(num);
                CantidadJugadores();
                break;
                
            case 2:
                try
                {
                    FileReader fl = new FileReader("Record.txt");
                    BufferedReader br = new BufferedReader(fl);
                    
                    String linea = br.readLine();           //Lectura por Linea
                    while(linea!=null){                      //Condicion para detener la lectura
                    System.out.println(linea);           //Impresion de la linea
                    linea=br.readLine();
                    }
                }
                catch(FileNotFoundException e){            //Excepciones
                System.out.println("No se encontro el archivo");
                System.exit(0);
                }
                catch(IOException e){
                    System.out.println("Ocurrio un error I/O");
                    System.exit(0);
                } 

                System.out.println("\n");
                
                break;
              
            case 3:
                
                System.out.println("            SERPIENTES Y ESCALERAS\n"
                        + "=======================================================\n"
                        + "\nEl juego Serpientes y Escaleras Unimet es una modificacion al"
                        + "\nclasico juego Snake & Ladders, cuyo objetivo principal es llegar "
                        + "\nal final primero que tus oponentes. La pista cuyo recorrido consta"
                        + "\nde 64 casillas, tiene obstaculos, que son serpientes, cuya "
                        + "\nfuncion es disminuir tu posicion en caso de pisar la cabeza. Pero "
                        + "\neste recorrido tambien consta de ventajas, que son las escaleras,"
                        + "\nestas aumentan tu posicion en el momento que caes en el pie de una."
                        + "\nEsta adaptacion del juego original esta hecha por Bernardo Bello"
                        + "\ny Guillermo Hellmund.");
                System.out.println("\nPara volver al menu inicial presione [1]");
                int opcion = sc.nextInt();
                if(opcion == 1)
                    Juego(Menu());
                
                break;
        }
    }
    
//    public void TipoJuego ()
//    {
//        Tablero tab = new Tablero();
//        System.out.println("Ingrese el modo de juego, [1] Termina al pasar 64  [2] Termina en 64 exacto si no sedes turno");
//        int tipo = sc.nextInt();
//        if(tipo ==1){
//             return true;
//        }else{
//
//            return false;
//        }
//        
//        
//    }
    
    public void CantidadJugadores() throws IOException
    {
        int selec = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cuantos jugadores van a ser ingresados? 2-4");
        int num =0;
        selec = sc.nextInt();
        switch(selec)
        {
            case 2:
                Jugar2();               
            break;
                
            case 3:
                Jugar3();
            break;
                
            case 4:
                Jugar4();
            break;
                
            default:
                System.out.println("Numero invalido ingresado. Vuelva a ingresarlo por favor");
            break;
                
        }
    }
    
    public void Jugar2() throws IOException
    {
        
        Tablero tab = new Tablero();
        int num;
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        
        
        System.out.println("[Jugador 1] Introduzca su nombre: ");
        String nombre = sc.next();
        jug.setNombre(nombre);
        
        System.out.println("[Jugador 2] Introduzca su nombre: ");
        nombre = sc.next();
        jug2.setNombre(nombre);
        
        
        tab.CrearTableroJuego();
                int cont1=1;
                
                do
                {
                    cont1++;

                    if(cont1%2==0)
                    {

                        System.out.println("[Jugador 1]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1){
                            tab.MostrarTablero(jug);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());

                            System.out.println("\n");
                        }

                    }
                    else
                    {

                        System.out.println("[Jugador 2]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1)
                        {
                            tab.MostrarTablero(jug2);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\n");
                        }
                    }
                }
                while(jug.posFinal <= 64 && jug2.posFinal <= 64);
                

    }
    
    public void Jugar3() throws IOException
    {
        Tablero tab = new Tablero();
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        Jugadores jug3 = new Jugadores();
        
        System.out.println("[Jugador 1] Introduzca su nombre: ");
        String nombre = sc.next();
        jug.setNombre(nombre);
        
        System.out.println("[Jugador 2] Introduzca su nombre: ");
        nombre = sc.next();
        jug2.setNombre(nombre);
        
        System.out.println("[Jugador 3] Introduzca su nombre: ");
        nombre = sc.next();
        jug3.setNombre(nombre);
        
        int num;
        Scanner sc = new Scanner(System.in);
        tab.CrearTableroJuego();
                int cont2=2;
                
                do
                {
                    cont2++;

                    if(cont2%3==0)
                    {

                        System.out.println("[Jugador 1]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1)
                        {
                            tab.MostrarTablero(jug);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                            System.out.println("\n");
                        }

                    }
                    else if(cont2%3==1)
                    {
                        System.out.println("[Jugador 2]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1)
                        {
                            tab.MostrarTablero(jug2);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                            System.out.println("\n");
                        }
                    }
                    else
                    {

                        System.out.println("[Jugador 3]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1){
                            tab.MostrarTablero(jug3);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                            System.out.println("\n");
                        }
                    }    
                }while(jug.posFinal <= 64 && jug2.posFinal <= 64 && jug3.posFinal <=64);
                
    }
    
    public void Jugar4() throws IOException
    {
        Tablero tab = new Tablero();
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        Jugadores jug3 = new Jugadores();
        Jugadores jug4 = new Jugadores();
        
        System.out.println("[Jugador 1] Introduzca su nombre: ");
        String nombre = sc.next();
        jug.setNombre(nombre);
        
        System.out.println("[Jugador 2] Introduzca su nombre: ");
        nombre = sc.next();
        jug2.setNombre(nombre);
        
        System.out.println("[Jugador 3] Introduzca su nombre: ");
        nombre = sc.next();
        jug3.setNombre(nombre);
        
        System.out.println("[Jugador 4] Introduzca su nombre: ");
        nombre = sc.next();
        jug4.setNombre(nombre);
        
        int num;
        Scanner sc = new Scanner(System.in);
        
        tab.CrearTableroJuego();
                int cont3=3;
                
                do{
                cont3++;
                
                if(cont3%4==0)
                {
                    
                    System.out.println("[Jugador 1]Desea lanzar el dado?: [1] Si  [2] No");
                    num=sc.nextInt();
                    if(num==1){
                        tab.MostrarTablero(jug);
                        System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                        System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                        System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                        System.out.println("\nPosicion [Jugador 4]: "+jug4.getPosFinal());
                        System.out.println("\n");
                    }

                }else if(cont3%4==1)
                {
                    System.out.println("[Jugador 2]Desea lanzar el dado?: [1] Si  [2] No");
                    num=sc.nextInt();
                    if(num==1){
                        tab.MostrarTablero(jug2);
                        System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                        System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                        System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                        System.out.println("\nPosicion [Jugador 4]: "+jug4.getPosFinal());
                        System.out.println("\n");
                    }
                }else if(cont3%4==2)
                {
                    System.out.println("[Jugador 3]Desea lanzar el dado?: [1] Si  [2] No");
                    num=sc.nextInt();
                    if(num==1){
                        tab.MostrarTablero(jug3);
                        System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                        System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                        System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                        System.out.println("\nPosicion [Jugador 4]: "+jug4.getPosFinal());
                        System.out.println("\n");
                    }
                }else 
                {
                    
                    System.out.println("[Jugador 4]Desea lanzar el dado?: [1] Si  [2] No");
                    num=sc.nextInt();
                    if(num==1){
                        tab.MostrarTablero(jug4);
                        System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                        System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                        System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                        System.out.println("\nPosicion [Jugador 4]: "+jug4.getPosFinal());
                        System.out.println("\n");
                    }
                }    
                }while(jug.posFinal <= 64 && jug2.posFinal <= 64 && jug3.posFinal <= 64 && jug4.posFinal <= 64);
                
    }
    
    public static void main(String[] args) throws IOException 
    {
        SerpientesYEscaleras sye = new SerpientesYEscaleras();
        Tablero tab = new Tablero();
        
        sye.Juego(sye.Menu()); 
        
        
       

        
    }
    
}
