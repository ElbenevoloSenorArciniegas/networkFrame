/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.LinkedList;
import java.util.Queue;
import vista.Vista;

/**
 *
 * @author Fredy Arciniegas
 */
public class Interfaz {

    Vista v;

    Hilo creador;
    Hilo lanzador;
    Hilo consumidor;
    Hilo server;

    Queue<String> miCola = new LinkedList<>();
    int miColaTamaño = 10;
    Queue<String> colaRecibida = new LinkedList<>();
    int colaRecibidaTamaño = 10;

    public Interfaz(String host, int port) {
        v= new Vista(this);
        v.setVisible(true);
        v.inicializar(host+":"+port,miColaTamaño,colaRecibidaTamaño);
        server = new Server(this, port);        
        creador = new Creador(this);
        creador.start();
        consumidor = new Consumidor(this);
        consumidor.start();
    }

    public void conectar(String host, int port) {
        lanzador = new Lanzador(this, host, port);
        lanzador.start();
    }

    void crear(String trama) {
        if (miCola.size() < miColaTamaño) {
            miCola.add(trama);
            v.sumarMicola(trama);
        } else {
            creador.setOn(false);
        }
    }

    void consumir() {
        if (colaRecibida.size() > 0) {
            String trama = colaRecibida.poll();
            v.restarOtraCola(trama);
        } else {
            consumidor.setOn(false);
        }
    }

    void recibir(String trama) {
        if (colaRecibida.size() < colaRecibidaTamaño) {
            colaRecibida.add(trama);
            v.sumarOtraCola(trama);
            consumidor.setOn(true);
        } else {
            //lanzar trama por la borda
        }
    }

    String lanzar() {
        if (miCola.size() > 0) {
            String trama = miCola.poll();
            v.restarMiCola(trama);
            creador.setOn(true);
            return trama;
        } else {
            return null;
        }
    }    

}
