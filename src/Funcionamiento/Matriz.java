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
public class Matriz {
    public static int casillaX = 10;
    public static int casillaY = 10;
    public char matrizTablero [][]; 
    
    public Matriz(){
        matrizTablero = new char[casillaX][casillaY];
        for (int x=0; x<=casillaX-1; x++){
            for (int y=0; y<=casillaY-1; y++){
                matrizTablero[x][y]='0';
            }
        }
    }
    
    public void mostrarMatriz(){
        for (int x=0; x<=casillaX-1; x++){
            for (int y=0; y<=casillaY-1; y++){
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }
    }
    
    public void ponerBolas(int x, int y, char colorBola) {
        matrizTablero[x][y]=colorBola;
    }
}
