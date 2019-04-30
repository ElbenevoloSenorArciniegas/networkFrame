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
public class Creador extends Hilo{

    public Creador(Interfaz i) {
        super(i);
    }

    @Override
    public void ejecutar() {
        StringBuilder sb= new StringBuilder();
        int tamañoTrama=8; // ¿?¿?
        for (int j = 0; j < tamañoTrama; j++) {             
            long random = Math.round(Math.random());
            String bit = random +"";
            sb.append(bit);
        }
        //System.out.println(sb.toString());
        this.i.crear(sb.toString());
    }
    

}
