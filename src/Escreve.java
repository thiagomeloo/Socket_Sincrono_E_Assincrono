
import java.util.Scanner;

public class Escreve extends Thread {

    private Scanner entrada;
    
    public Escreve(Scanner entrada) {
        this.entrada = entrada;
    }

    @Override
    public void run() {
        while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
        
        
    }
    
    
    
    
    
    
    
    
}
