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
        tablero.ponerBolas(0, 1, 'c');
        tablero.ponerBolas(1, 1, 'c');
        tablero.ponerBolas(1, 2, 'c');
        tablero.ponerBolas(1, 0, 'b');
        tablero.ponerBolas(2, 1, 'c');
        tablero.ponerBolas(2, 3, 'a');
        System.out.println("");
        System.out.println("Segundo resultado");
        tablero.mostrarMatriz();
        System.out.println("");
        System.out.println("Tercer resultado");
        tablero.seleccionarBolas(0, 1);
    }
}
