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
public class Consumidor extends Hilo{

    public Consumidor(Interfaz i) {
        super(i);
    }

    @Override
    public void ejecutar() {
        this.i.consumir();    
    }
    

}
