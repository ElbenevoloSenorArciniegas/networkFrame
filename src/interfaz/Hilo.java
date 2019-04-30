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
public abstract class Hilo extends Thread {

    Interfaz i;
    boolean on;
    private final int n = (int) (Math.random()*1500+500);

    public Hilo(Interfaz i) {
        this.i = i;
        on = true;
    }

    public abstract void ejecutar();

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(n);
                if (on) {
                    this.ejecutar();
                }
            } catch (InterruptedException ex) {
                System.err.println(ex.getLocalizedMessage());
            }

        }
    }
}
