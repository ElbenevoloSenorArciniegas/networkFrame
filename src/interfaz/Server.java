package interfaz;

import java.io.*;
import java.net.*;

public class Server extends Hilo {

    ServerSocket mi_servicio = null;
    String linea_recibida;
    DataInputStream entrada;
    PrintStream salida;
    Socket socket_conectado = null;    

    public Server(Interfaz i, int port) {
        super(i);
        try {
            mi_servicio = new ServerSocket(port);
            this.start();
        } catch (IOException excepcion) {
            System.out.println(excepcion);
        }
    }

    @Override
    public void run() {
        try {
            socket_conectado = mi_servicio.accept();
            entrada = new DataInputStream(socket_conectado.getInputStream());
            salida = new PrintStream(socket_conectado.getOutputStream());
            while (on) {
                linea_recibida = entrada.readLine();
                this.i.recibir(linea_recibida);
                salida.println("recibido");
//                salida.close();
//                entrada.close();
//                socket_conectado.close();
            }
        } catch (IOException excepcion) {
            System.out.println(excepcion);
        }
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
