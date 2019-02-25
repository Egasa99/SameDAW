/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionamiento;

/**
 *
 * @author User
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz tablero = new Matriz();
        System.out.println("Primer resultado");
        tablero.mostrarMatriz();
        tablero.ponerBolas(2, 4, 'a');
        tablero.ponerBolas(2, 5, 'r');
        tablero.ponerBolas(1, 7, 'x');
        tablero.ponerBolas(7, 9, 'w');
        tablero.ponerBolas(2, 1, 'a');
        System.out.println("");
        System.out.println("Segundo resultado");
        tablero.mostrarMatriz();
    }
}
