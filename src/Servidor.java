import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Servidor {
    
    public static void main(String[] args) {
        
        try {
            System.out.println("Recebendo Oferenda...");
            ServerSocket servidor = new ServerSocket(12345);
            Socket o_cliente = servidor.accept();
            System.out.println("Cliente: " + o_cliente.getInetAddress().getHostAddress() + " conectado");
            
           
            
            InputStream ex = o_cliente.getInputStream();
            
            Scanner lerDoSocketCliente = new Scanner(ex);
            
            //botei aqui
            PrintStream saidaServidor = new PrintStream(o_cliente.getOutputStream());
            Scanner teclado = new Scanner(System.in);
            
            
            
            while(lerDoSocketCliente.hasNextLine()){
                System.out.println(lerDoSocketCliente.nextLine());
                saidaServidor.println(teclado.nextLine());
            }
            
            
        } catch (IOException ex) {
            
            System.out.println("Erro na criação do servidor");
            
        }
        
        
    }
     
    
}
