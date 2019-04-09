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
        tablero.PonerBolasInicio();
        tablero.ponerBolas(3, 0, 'a');
        tablero.ponerBolas(3, 1, 'a');
        tablero.ponerBolas(3, 2, 'a');
        tablero.ponerBolas(3, 3, 'a');
        tablero.ponerBolas(3, 4, 'a');
        tablero.ponerBolas(3, 5, 'a');
        tablero.ponerBolas(3, 6, 'a');
        tablero.ponerBolas(3, 7, 'a');
        tablero.ponerBolas(3, 8, 'a');
        tablero.ponerBolas(3, 9, 'a');
        tablero.ponerBolas(5, 0, 'a');
        tablero.ponerBolas(5, 1, 'a');
        tablero.ponerBolas(5, 2, 'a');
        tablero.ponerBolas(5, 3, 'a');
        tablero.ponerBolas(5, 4, 'a');
        tablero.ponerBolas(5, 5, 'a');
        tablero.ponerBolas(5, 6, 'a');
        tablero.ponerBolas(5, 7, 'a');
        tablero.ponerBolas(5, 8, 'a');
        tablero.ponerBolas(5, 9, 'a');
        tablero.tocarBolas(3, 3);
        System.out.println("Primer resultado");
        tablero.mostrarMatriz();
        System.out.println();
        tablero.Combinaciones();
        tablero.tocarBolas(3, 3);
        System.out.println("Segundo resultado");
        tablero.mostrarMatriz();
        System.out.println();
        tablero.reajustarBolas();
        tablero.Combinaciones();
        System.out.println("Ultimo resultado");
        tablero.mostrarMatriz();
        tablero.mostrarPuntuacion();
        tablero.Combinaciones();
    }
}
