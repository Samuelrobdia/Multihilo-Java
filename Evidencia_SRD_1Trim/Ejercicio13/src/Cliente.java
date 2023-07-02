import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente {
    
    public static void main(String[] args) {
        
        System.out.println("Aplicacion Cliente");
        System.out.println("-------------------");

        Socket cliente = new Socket();
        InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 5000);
        System.out.println("Esperando a que el servidor acepte la conexion");

        try {
            Scanner sc = new Scanner(System.in);

            cliente.connect(direccionServidor);
            System.out.println("Comunicacion establecida con el servidor");

            OutputStream salida = cliente.getOutputStream();
            InputStream entrada = cliente.getInputStream();

            System.out.print("Dime un numero: ");
            String numero = sc.nextLine();

            salida.write(numero.getBytes());


            byte[] respuesta = new byte[100];
            entrada.read(respuesta);
            String num = new String(respuesta);

            System.out.println("El numero factorial es: "+ num);

            entrada.close();
            salida.close();
            cliente.close();
            System.out.println("Comunicacion cerrada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


