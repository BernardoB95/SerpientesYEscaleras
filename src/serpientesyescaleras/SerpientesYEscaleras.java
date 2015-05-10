
package serpientesyescaleras;


public class SerpientesYEscaleras {

    
    public static void main(String[] args) {
       
        int cont=1;
        
        for (int i = 0; i < 8; i++) 
            for (int j = 0; j < 8; j++) 
                for (int k = 0; k < 8; k++) 
                {
                    System.out.println("");
                    for (int l = 8; l > 0; l--) 
                    {
                        System.out.print(cont+"\t");
                        cont++;
                    }
                }
            
        
            
        
    }
    
}
