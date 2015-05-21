
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
                System.out.println("\nPara volver al menu inicial presione [1]");
                int opcion = sc.nextInt();
                if(opcion == 1)
                    Juego(Menu());
                
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
                opcion = sc.nextInt();
                if(opcion == 1)
                    Juego(Menu());
                
                break;
        }
    }
    
    
    public void CantidadJugadores() throws IOException  // Estructura que contiene los metodos de jugar
    {
        int selec = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cuantos jugadores van a ser ingresados? 2-4");
        int num =0;
        selec = sc.nextInt();
        switch(selec)
        {
            case 2:
                System.out.println("Modalidad: [1] Facil  [2]Dificil");
                Jugar2();               
            break;
                
            case 3:
                System.out.println("Modalidad: [1] Facil  [2]Dificil");
                Jugar3();
            break;
                
            case 4:
                System.out.println("Modalidad: [1] Facil  [2]Dificil");
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
        int opcion;
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        
        do
        {
        opcion = sc.nextInt();  //Scanner opcion, pase por parametros
        if(opcion!=1 && opcion !=2)
                System.out.println("Valor incorrecto. Vuelva a ingresarlo");
        }
        while(opcion!=1 && opcion !=2);
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
                    cont1++;//Contador par o impar

                    if(cont1%2==0)//Validacion div modular para jug1
                    {

                        System.out.println("[Jugador 1]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1){
                            tab.MostrarTablero(jug,opcion);//Envia parametro a MostrarTab
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());

                            System.out.println("\n");
                        }

                    }
                    else//Validacion div modular para jug2
                    {

                        System.out.println("[Jugador 2]Desea lanzar el dado?: [1] Si  [2] No");
                        num=sc.nextInt();
                        if(num==1)
                        {
                            tab.MostrarTablero(jug2,opcion);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\n");
                        }
                    }
                }
                while(jug.posFinal <= 64 && jug2.posFinal <= 64);//Condicion de fin de juego
                

    }
    
    public void Jugar3() throws IOException //Asume los comentarios de manera similar a Jugar2
    {
        Tablero tab = new Tablero();
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        Jugadores jug3 = new Jugadores();
        int opcion;
        
        do
        {
        opcion = sc.nextInt();
        if(opcion!=1 && opcion !=2)
                System.out.println("Valor incorrecto. Vuelva a ingresarlo");
        }
        while(opcion!=1 && opcion !=2);
        
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
                            tab.MostrarTablero(jug,opcion);
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
                            tab.MostrarTablero(jug2,opcion);
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
                            tab.MostrarTablero(jug3,opcion);
                            System.out.println("\nPosicion [Jugador 1]: "+jug.getPosFinal());
                            System.out.println("\nPosicion [Jugador 2]: "+jug2.getPosFinal());
                            System.out.println("\nPosicion [Jugador 3]: "+jug3.getPosFinal());
                            System.out.println("\n");
                        }
                    }    
                }while(jug.posFinal <= 64 && jug2.posFinal <= 64 && jug3.posFinal <=64);
                
    }
    
    public void Jugar4() throws IOException //Asume los comentarios de manera similar a Jugar2 y Jugar3
    {
        Tablero tab = new Tablero();
        Jugadores jug = new Jugadores();
        Jugadores jug2 = new Jugadores();
        Jugadores jug3 = new Jugadores();
        Jugadores jug4 = new Jugadores();
        int opcion;
        do
        {
        opcion = sc.nextInt();
        if(opcion!=1 && opcion !=2)
                System.out.println("Valor incorrecto. Vuelva a ingresarlo");
        }
        while(opcion!=1 && opcion !=2);
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
                        tab.MostrarTablero(jug,opcion);
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
                        tab.MostrarTablero(jug2,opcion);
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
                        tab.MostrarTablero(jug3,opcion);
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
                        tab.MostrarTablero(jug4,opcion);
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
