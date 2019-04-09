/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionamiento;
import Pantalla.SameDAW;
import java.util.Random;


/**
 *
 * @author User
 */
import javafx.application.Application;
public class Matriz {
//  atributos de la clase Matriz
//  public static final int CASILLA_X = 10;
//  public static final int CASILLA_Y = 10;
    public static int numColores = 4;
    public static int puntuacionBolas = 0;
    public static int contadorBolas = 0;
    public static int señalarBolaX = 1000;
    public static int señalarBolaY = 1000;
    public char matrizTablero [][]; 
    SameDAW samedaw = new SameDAW();
    
    // Método constructor de la clase Matriz
    public Matriz(){
        matrizTablero = new char[samedaw.casillaX][samedaw.casillaY];
        for (int x=0; x<=samedaw.casillaX-1; x++){
            for (int y=0; y<=samedaw.casillaY-1; y++){
                matrizTablero[x][y]='0';
            }
        }
    }
    
    // Muestra por pantalla el array de la clase Matriz
    public void mostrarMatriz(){
        for (int y=0; y<=samedaw.casillaY-1; y++){
            for (int x=0; x<=samedaw.casillaX-1; x++){
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }
    }

   // Coloca la bola en la ubicación dada en los parametros y con el color especificado. Con el se puede poner una bola de cierto color en una ubicacion especifica
    public void ponerBolas(int x, int y, char colorBola) {
        matrizTablero[x][y]=colorBola;
    }
    
    // Tocar una bola la convierte en mayúscula, solo puede haber una mayúscula. Al tocar la mayúscula se elimina el conjunto de su color que esté en contacto
    public void tocarBolas(int x, int y){
        if (90<matrizTablero[x][y]){
            try {
                matrizTablero[señalarBolaX][señalarBolaY] = (char) (matrizTablero[señalarBolaX][señalarBolaY] + 32);
            }catch(Exception e) {
            }
            señalarBolaX = x;
            señalarBolaY = y;
            System.out.println("Señalar bolas en: " + señalarBolaX + " y " + señalarBolaY);
            matrizTablero[x][y] = (char) (matrizTablero[x][y] - 32);
        }
        else{
            System.out.println("eliminando bolas...");
            matrizTablero[señalarBolaX][señalarBolaY] = (char) (matrizTablero[señalarBolaX][señalarBolaY] + 32);
            eliminarBolas(x,y);
            señalarBolaX = 1000;
            señalarBolaY = 1000;
        };
    }
    
    // Elimina las bolas del mismo color que esten en contacto con la especificada por parámetros
    public void eliminarBolas(int x, int y){
        char colorBolaInicial = matrizTablero[x][y];
            try {
                if (matrizTablero[x+1][y]==colorBolaInicial){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';
                    eliminarBolas(x+1,y);
                }
                if (matrizTablero[x+1][y]=='*'){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x-1][y]==colorBolaInicial){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';
                    eliminarBolas(x-1,y);
                }
                if (matrizTablero[x-1][y]=='*'){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';                    
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x][y+1]==colorBolaInicial){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';
                    eliminarBolas(x,y+1);
                }
                if (matrizTablero[x][y+1]=='*'){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';                    
                }
            } catch(Exception e) {
            }

            try {
                if (matrizTablero[x][y-1]==colorBolaInicial){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';
                    eliminarBolas(x,y-1);
                }
                if (matrizTablero[x][y-1]=='*'){
                    if(matrizTablero[x][y]!='*'){
                        contadorBolas++;
                    }
                    matrizTablero[x][y]='*';                    
                }
            } catch(Exception e) {
            }
    }
    
    // calcula la puntuación y la muestra
    public void mostrarPuntuacion(){
        calcularPuntuacion();
        System.out.println("La puntuación es :" + puntuacionBolas);
    }
    
    // Al eliminar bolas se guarda el número de bolas eliminadas, con el se saca la puntuación obtenida y se suma a la puntuación total
    public int calcularPuntuacion(){
        puntuacionBolas += contadorBolas*contadorBolas;
        return puntuacionBolas;
    }
    
    // Una vez eliminemos las bolas este método las recolocará hacia abajo y hacia la izquierda cuando sea necesario 
    public void reajustarBolas(){
        boolean fila = true;
        for (int x = (samedaw.casillaX-1); x>=0; x--){
            for (int y = (samedaw.casillaY-1); y>=0; y--){
                if (matrizTablero[x][y]=='*'){
                    for (int y2 = y; y2>=1; y2--){
                            matrizTablero[x][y2]=matrizTablero[x][y2-1];
                    }
                    matrizTablero[x][0]='z';
                    y++;
                }
            }
            for (int y = (samedaw.casillaY-1); y>=0; y--){
                if (matrizTablero[x][y]!='z'){
                    fila = false;
                }
            }
            if (fila == true){
                System.out.println(fila);
                for(int x2 = x; x2<=(samedaw.casillaX-1); x2++){
                    for (int y = 0; y<=(samedaw.casillaY-1); y++){
                        if(matrizTablero[x2][y]=='z'){
                            try {
                                matrizTablero[x2][y]=matrizTablero[x2+1][y];
                                matrizTablero[x2+1][y]='z';
                            }catch(Exception e){
                            }
                        }
                    }
                }
            } else {
                fila = true;
            }
        }
    }
    
    // Comprueba si hay combinaciones posibles
    public boolean Combinaciones(){
        boolean hayCombinaciones = false;
        for (int y=0; y<=samedaw.casillaX-1; y++){
            for (int x=0; x<=samedaw.casillaY-1; x++){
                
                char colorBolaInicial = matrizTablero[x][y];
            
                try {
                        if (matrizTablero[x+1][y]==colorBolaInicial){
                            hayCombinaciones=true;
                        }
                    } catch(Exception e) {
                    }

                    try {
                        if (matrizTablero[x-1][y]==colorBolaInicial){
                            hayCombinaciones=true;
                        }
                    } catch(Exception e) {
                    }

                    try {
                        if (matrizTablero[x][y+1]==colorBolaInicial){
                            hayCombinaciones=true;
                        }
                    } catch(Exception e) {
                    }

                    try {
                        if (matrizTablero[x][y-1]==colorBolaInicial){
                            hayCombinaciones=true;
                        }
                    } catch(Exception e) {
                    }
            }
        }
        System.out.println("La comprobación de 'hay combinaciones' ha dado como resultado " + hayCombinaciones);
        return hayCombinaciones;
    }
    
    // Coloca bolas aleatoriamente con los distintos colores indicados y recoloca de nuevo las que no tienen combinaciones
    public void PonerBolasInicio(){
        char a = 'a';
        boolean hayCombinaciones = false;
        Random randomColores = new Random(); 
        for (int y=0; y<=samedaw.casillaX-1; y++){
            for (int x=0; x<=samedaw.casillaY-1; x++){
                matrizTablero[x][y]= (char)(a + randomColores.nextInt(numColores));
            }
        }
        for (int y=0; y<=samedaw.casillaX-1; y++){
            for (int x=0; x<=samedaw.casillaY-1; x++){
                char colorBolaInicial = matrizTablero[x][y];
                try {
                    if (matrizTablero[x+1][y]==colorBolaInicial){
                        hayCombinaciones=true;
                    }
                } catch(Exception e) {
                }

                try {
                    if (matrizTablero[x-1][y]==colorBolaInicial){
                        hayCombinaciones=true;
                    }
                } catch(Exception e) {
                }

                try {
                    if (matrizTablero[x][y+1]==colorBolaInicial){
                        hayCombinaciones=true;
                    }
                } catch(Exception e) {
                }

                try {
                    if (matrizTablero[x][y-1]==colorBolaInicial){
                        hayCombinaciones=true;
                    }
                } catch(Exception e) {
                }
                if (!hayCombinaciones){
                    matrizTablero[x][y]= (char)(a + randomColores.nextInt(numColores));
                }
                hayCombinaciones=false;
            }
        }
    }
}
