/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaz.Interfaz;

/**
 *
 * @author Fredy Arciniegas
 */
public class SuperMain {
    
    public static void main(String[] args) {
        Interfaz i1 = new Interfaz("localhost",5000);
        Interfaz i2 = new Interfaz("localhost",6000);                
    }
    
}
