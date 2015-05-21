
package serpientesyescaleras;

import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tablero {
     Scanner sc = new Scanner(System.in);
    
    
    private Fichas Matriz[][] = new Fichas[8][8];
    private Serpientes vecS[];
    private Escaleras vecE[];  
    private File archivo = new File("Record.txt");
    int cont = 1;
    int cont6 = 0;
    
    
   
    
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
                    Casilla.setStatusS(false);
                    Casilla.setStatusE(false);
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
                    Casilla.setStatusS(false);
                    Casilla.setStatusE(false);
                    Matriz[i][j]=Casilla;
                    cont++;
                }
            }
        } 
         try {
             AsiganarSerpiente();
         } catch (IOException ex) {
             Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
         }
        AsiganarEscalera();
        
        
    }
    
    public void MostrarTablero(Jugadores jugador, int num) throws IOException//Impresion de tablero, parametro MATRIZ
    {
        
        int rand =jugador.LanzarDado();
        int pos = jugador.Accion(rand);
        boolean ver=false;
        Scanner sc = new Scanner(System.in);
        
        if(jugador.getPosFinal()<64)//Validacion FIN JUEGO
        {
            if(rand!=6)
                cont6=0;
        if(rand==6)
            jugador.setStatus(false);
        
        if(jugador.isStatus()== true)
        {
            System.out.println("\n         Has sacado ["+rand+"] en el dado\n");
            System.out.println("Debe sacar 6 para ser desbloqueado de la posicion [0]");
        }
        else
        {
            do{
                if(ver == true){
                    System.out.println("\n\nHas caido en una serpiente/escalera, su nueva posicion es ->"+pos+"\n");
                }                
                ver = false;
                if(pos>64 && TipoJuego(num) == false){//Recibe el parametro y lo manda a la funcion tipoJuego
                    System.out.println("Has sido devuelto a tu casilla ya que debes llegar exacto a 64");
                    pos = pos - rand;
                }
                System.out.println("\n         Has sacado ["+rand+"] en el dado\n");
                System.out.println("                     TABLERO");
             for (int i = 0; i < 8; i++)
             {
                 System.out.println("");
                 for (int j = 0; j < 8; j++)
                 {
                     if (Matriz[i][j].isStatusS()==true){
                          System.out.print("[ $]\t");
                          if(jugador.getPosFinal() == Matriz[i][j].getIndice())
                          {
                              
                             jugador.setPosFinal(Matriz[i][j].getPosFinalS());
                             jugador.setPosInicial(Matriz[i][j].getPosFinalS());
                             pos = Matriz[i][j].getPosFinalS();
                              ver=true;
                          }
                     }else if (Matriz[i][j].isStatusE()==true){
                          System.out.print("[ #]\t"); 
                          if(jugador.getPosFinal() == Matriz[i][j].getIndice())
                          {
                              
                             jugador.setPosFinal(Matriz[i][j].getPosFinalE());
                             jugador.setPosInicial(Matriz[i][j].getPosFinalE());
                             pos = Matriz[i][j].getPosFinalE();
                              ver=true;
                          }
                     }else if(Matriz[i][j].getIndice() == pos)
                     {
                         System.out.print("[X]\t");
                     }else {
                        System.out.print("["+Matriz[i][j].getIndice()+"]"+"\t"); 
                     }
                 }
             }
            }while(ver==true);
        }
        
               
        if(jugador.getPosFinal()<64){    
            if(rand == 6){
                cont6++;
                 if(cont6 == 3){
                     jugador.setStatus(true);
                     jugador.setPosFinal(0);
                     jugador.setPosInicial(0);
                     System.out.println("\nEl jugador se ha devuelto a la casilla [0]");
                     System.out.println("Volver a sacar 6 en proximas rondas para salir de la penalidad.");
                     System.out.println("");
                     cont6 =0;


                 }else{
                 System.out.println("");
                 System.out.println("Le toca repetir turno ya que salio 6. Lanzar el dado? [1] Si   [2] No");
                 int lanzar = sc.nextInt();
                 if(lanzar == 1)
                     MostrarTablero(jugador,num);
                 }

                }
            }

            
        
        }
        
        if(jugador.getPosFinal()>=64)
        {
            System.out.println("Felicidades! Has ganado");
        
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
            String nombre;

            if(archivo.exists())
            {
                nombre = jugador.getNombre();
                bw.write(nombre);
                bw.newLine();

                bw.close();
            }
        }
        
    
               
    }
        
    public boolean TipoJuego(int numero)//Recibe el parametro y determina si true o false
    {
        boolean variable = false;
     //Este boolean deberia retornar true o false para que el if de mostrarmtatriz furule   
        if(numero==1)
            variable = true;
        else if(numero==2)
            variable = false;
                    
        return variable;
    }
      
    public void AsiganarSerpiente(/*Jugadores Jugador*/) throws IOException// Modificacion parametro
    {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
        
        if(archivo.exists())
        {
            
        }
        
        System.out.println("Ingrese cuantas serpientes quiere agregar:");
        int num = sc.nextInt();
        int indicefinal=0;
        
        vecS = new Serpientes[num];
        
        for (int i = 0; i < vecS.length; i++) {
            int sval=0;
            int xi, yi, xf, yf;
            Serpientes snake = new Serpientes();
            do{
                if(sval>0){
                    System.out.println("Por favor ingrese un valor donde la cabeza este mas arriba que la cola\n");
                }
                sval++;
                System.out.println("Introduzca el valore X inicial");
                xi = sc.nextInt();
                System.out.println("Introduzca el valore Y inicial");
                yi = sc.nextInt();
                System.out.println("Introduzca el valore X final");
                xf = sc.nextInt();
                System.out.println("Introduzca el valore Y final");
                yf = sc.nextInt();
                snake.setIndiceS(Matriz[yi][xi].getIndice());
                snake.setIndiceSf(Matriz[yf][xf].getIndice());
            }while (snake.getIndiceS()<snake.getIndiceSf());
            Matriz[yi][xi].setStatusS(true);
            Matriz[yi][xi].setPosFinalS(snake.getIndiceSf());
            vecS[i] = snake;
            
            
        }
    
        
    }
    
        public void AsiganarEscalera()
    {
        System.out.println("Ingrese cuantas escaleras quiere agregar:");
        int num = sc.nextInt();
        
        vecE = new Escaleras[num];
        
        for (int i = 0; i < vecE.length; i++) {
            int eval=0;
            int xi, yi, xf, yf;
            Escaleras ladders = new Escaleras();
            do{
                if(eval>0){
                    System.out.println("Por favor ingrese un valor donde el principio de la escalera este abajo del final\n");
                }
                eval++;
                System.out.println("Introduzca el valore X inicial");
                xi = sc.nextInt();
                System.out.println("Introduzca el valore Y inicial");
                yi = sc.nextInt();
                System.out.println("Introduzca el valore X final");
                xf = sc.nextInt();
                System.out.println("Introduzca el valore Y final");
                yf = sc.nextInt();
                ladders.setIndiceE(Matriz[yi][xi].getIndice());
                ladders.setIndiceEf(Matriz[yf][xf].getIndice());
            }while(ladders.getIndiceE()>ladders.getIndiceEf());
            Matriz[yi][xi].setStatusE(true);
            Matriz[yi][xi].setPosFinalE(ladders.getIndiceEf());
            vecE[i] = ladders;
         
        }
        
//        public 
    }
    
}
