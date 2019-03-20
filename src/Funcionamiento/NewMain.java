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
        tablero.ponerBolas(0, 1, 'c');
        tablero.ponerBolas(1, 1, 'c');
        tablero.ponerBolas(1, 2, 'c');
        tablero.ponerBolas(1, 0, 'b');
        tablero.ponerBolas(2, 1, 'c');
        tablero.ponerBolas(3, 1, 'c');
        tablero.ponerBolas(4, 1, 'c');
        tablero.ponerBolas(5, 1, 'c');
        tablero.ponerBolas(6, 1, 'c');
        tablero.ponerBolas(2, 3, 'a');
        System.out.println("Primer resultado");
        tablero.mostrarMatriz();
        System.out.println();
        System.out.println("Segundo resultado");
        tablero.eliminarBolas(1, 1);
        tablero.mostrarMatriz();
        tablero.reajustarBolas();
        System.out.println();
        System.out.println("Ultimo resultado");
        tablero.mostrarMatriz();
    }
}
