/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Fredy Arciniegas
 */
import java.io.*;
import java.net.*;

public class Lanzador extends Hilo {

    Socket cliente = null;
    DataInputStream entrada = null;
    DataOutputStream salida = null;

    public Lanzador(Interfaz i, String host, int port) {
        super(i);
        try {
            cliente = new Socket(host, port);
            entrada = new DataInputStream(cliente.getInputStream());
            // será lo que enviaremos al servidor	
            salida = new DataOutputStream(cliente.getOutputStream());
            // será lo que nos devuelva el servidor	            
        } catch (UnknownHostException excepcion) {
            System.err.println("El servidor no está escuchando");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @Override
    public void ejecutar() {
        String trama = this.i.lanzar();
        if (trama != null) {
            try {
                String linea_recibida;
                salida.writeBytes(trama + "\n");
                linea_recibida = entrada.readLine(); //Sólo me interesa mandar y mandar, no interesa qué me respondan

//            System.out.println("SERVIDOR DICE: " + linea_recibida);
//            if(linea_recibida.equals("stop")){
//                this.on=false; //paro la conexión
//            }
//            salida.close();
//            entrada.close();
//            cliente.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
