
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
    
    public void MostrarTablero(Jugadores jugador)//Impresion de tablero, parametro MATRIZ
    {
        int rand =7;
        int pos = jugador.Accion(rand);
        boolean ver; 
        Scanner sc = new Scanner(System.in);
        
        if(rand!=6)
                cont6=0;
        if(rand==6)
            jugador.setStatus(false);
        
        if(jugador.isStatus()== true)
        {
            System.out.println("Debe sacar 6 para ser desbloqueado de la posicion [0]");
        }
        else
        {
            do{
                System.out.println("\n\nHas caido en una serpiente/escalera, su nueva posicion es ->"+pos+"\n");
                ver = false;
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
                MostrarTablero(jugador);
            }
           
       }     
        
        
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
            Serpientes snake = new Serpientes();
            System.out.println("Introduzca el valore X inicial");
            int xi = sc.nextInt();
            System.out.println("Introduzca el valore Y inicial");
            int yi = sc.nextInt();
            System.out.println("Introduzca el valore X final");
            int xf = sc.nextInt();
            System.out.println("Introduzca el valore Y final");
            int yf = sc.nextInt();
            Matriz[yi][xi].setStatusS(true);
            snake.setIndiceS(Matriz[yi][xi].getIndice());
            snake.setIndiceSf(Matriz[yf][xf].getIndice());
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
            Escaleras ladders = new Escaleras();
            System.out.println("Introduzca el valore X inicial");
            int xi = sc.nextInt();
            System.out.println("Introduzca el valore Y inicial");
            int yi = sc.nextInt();
            System.out.println("Introduzca el valore X final");
            int xf = sc.nextInt();
            System.out.println("Introduzca el valore Y final");
            int yf = sc.nextInt();            
            Matriz[yi][xi].setStatusE(true);
            ladders.setIndiceE(Matriz[yi][xi].getIndice());
            ladders.setIndiceEf(Matriz[yf][xf].getIndice());
            Matriz[yi][xi].setPosFinalE(ladders.getIndiceEf());
            
            //snake.setStatus(true);
            vecE[i] = ladders;
         
        }
        
//        public 
    }
    
}
