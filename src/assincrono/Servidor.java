package assincrono;

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
            
           
             
            Scanner lerDoSocketCliente = new Scanner(o_cliente.getInputStream());
            
            //botei aqui
            PrintStream saidaServidor = new PrintStream(o_cliente.getOutputStream());
            Scanner teclado = new Scanner(System.in);
            
            Escreve escreve = new Escreve(lerDoSocketCliente);
            escreve.start();
            
            while(teclado.hasNextLine()){
                saidaServidor.println(teclado.nextLine());
            }
            
            
        } catch (IOException ex) {
            
            System.out.println("Erro na criação do servidor");
            
        }
        
        
    }
     
    
}
