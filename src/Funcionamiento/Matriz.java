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
        for (int y=0; y<=casillaX-1; y++){
            for (int x=0; x<=casillaY-1; x++){
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }
    }

    public void ponerBolas(int x, int y, char colorBola) {
        matrizTablero[x][y]=colorBola;
    }
    
    public void eliminarBolas(int x, int y){
        char colorBolaInicial = matrizTablero[x][y];
        if (!(colorBolaInicial=='0')){
        matrizTablero[x][y]='*';
            try {
                if (matrizTablero[x+1][y]==colorBolaInicial){
                eliminarBolas(x+1,y);
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x-1][y]==colorBolaInicial){
                eliminarBolas(x-1,y);
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x][y+1]==colorBolaInicial){
                eliminarBolas(x,y+1);
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x][y-1]==colorBolaInicial){
                eliminarBolas(x,y-1);
                }
            } catch(Exception e) {
            }
        }
    }
    
    public void reajustarBolas(){
        for (int x = (casillaY-1); x>=0; x--){
            for (int y = (casillaX-1); y>=0; y--){
                if (matrizTablero[x][y]=='*'){
                    for (int y2 = y; y2>=1; y2--){
                            matrizTablero[x][y2]=matrizTablero[x][y2-1];
                    }
                    matrizTablero[x][0]='z';
                    y++;
                }
            }
        }
    }
}
