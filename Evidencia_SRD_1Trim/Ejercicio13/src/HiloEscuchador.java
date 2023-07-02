import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;

    public HiloEscuchador(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente" + numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());

        try {

            OutputStream salida = enchufeAlCliente.getOutputStream();
            InputStream entrada = enchufeAlCliente.getInputStream();

            byte[] numero = new byte[100];
            entrada.read(numero);
            String texto = new String(numero);

            int num = Integer.parseInt(texto.trim());
            int factorial = 1;

            for(int i = 1; i<= num; i++){
                factorial = factorial * i;
            }

            // System.out.println("El numero desde el cliente es: "+ texto.trim());
            // System.out.println("El factorial de ese numero es: "+ factorial);

            String factorialtxt = ""+ factorial;
            salida.write(factorialtxt.getBytes());

            entrada.close();
            salida.close();
            enchufeAlCliente.close();
            
            if(enchufeAlCliente.isClosed()){
                System.out.println(hilo.getName()+" desconectado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}
