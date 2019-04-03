/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

import Funcionamiento.Matriz;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author PC06
 */
public class SameDAW extends Application {
    double tamanoCasilla = 51.2;  // 51.2 
    int dato = 6;
    public int casillaX = 0;
    public int casillaY = 0;
    int multiplicador = (int) Math.pow((dato-1),2);
    double finalCasillaX = tamanoCasilla*casillaX;
    double finalCasillaY = tamanoCasilla*casillaY;
    double dimensionX = 461; //finalCasillaX+3
    double dimensionY = 512; //finalCasillaY+70
    Pane root;
    HBox Hbox1;
    Line line;
    Line line2;
    private Matriz matriz;
    String localUrl;
    ImageView imageView;
    int valor = 0;
    
    public Matriz getTablero(){
        return matriz;
    }
    
    public void mostrarMatriz(){
        for (int y=0; y<=casillaX; y++){
            for (int x=0; x<=casillaY; x++){
                Circle circulo1 = new Circle(tamanoCasilla);
                circulo1.setFill(Color.rgb(255,0,0,1.0));
                circulo1.setLayoutX(x*tamanoCasilla/2);
                circulo1.setLayoutY(y*tamanoCasilla/2);
            }
        }
    }
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        BorderPane border = new BorderPane();
        primaryStage.setResizable(false);
        
        
        //menuItem
        Menu menu = new Menu("Juego");
        MenuItem menuItem1 = new MenuItem("Empezar Juego    F5");
        menuItem1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                System.out.println("handle menuItem1");
                
                for (int i = 0; i < finalCasillaX; i+= tamanoCasilla) {
                    root.getChildren().remove(line2);
                }
                
                for (int i = 0; i < finalCasillaY; i+= tamanoCasilla) {
                    root.getChildren().remove(line2);
                }
                
                //Ventana extra emergente
                Pane root2 = new Pane();
                Scene secondScene = new Scene(root2, 256, 512);
                Stage newWindow = new Stage();
                newWindow.setTitle("Configuracion");
                newWindow.setScene(secondScene);
                newWindow.setX(primaryStage.getX()+(primaryStage.getX()/2));
                newWindow.setY(primaryStage.getY()+(primaryStage.getY()/2));
                newWindow.show();
                Label label2 = new Label("Tamaño");
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.setItems(FXCollections.observableArrayList(
                "Pequeño", "Mediano", "Grande", "Personalizado"));
                choiceBox.getSelectionModel().selectFirst();
                Label labelSizeC1 = new Label("Alto ");
                
                TextField textField = new TextField ();
                textField.lengthProperty();
                    textField.textProperty().addListener(new ChangeListener<String>() {
                        public void changed(ObservableValue<? extends String> observable, String oldValue,String newValue) {
                            if (!newValue.matches("\\d*")) {
                                textField.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
                Label labelSizeX = new Label(" X ");
                Label labelSizeC2 = new Label("Ancho ");
                
                TextField textField2 = new TextField ();
                textField2.textProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable, String oldValue,String newValue) {
                        if (!newValue.matches("\\d*")) {
                            textField2.setText(newValue.replaceAll("[^\\d]", ""));
                        }
                    }
                });
                
                
                
                
                HBox Hbox1= new HBox(labelSizeC1,textField,labelSizeX,labelSizeC2,textField2);
                Hbox1.setVisible(false);
                //tamaño por defecto
                System.out.println("Pequeño");
                casillaX = 3;
                casillaY = 4;
                primaryStage.setWidth(dimensionX);
                primaryStage.setHeight(dimensionY);
                finalCasillaX = tamanoCasilla*casillaX;
                finalCasillaY = tamanoCasilla*casillaY;
                
                choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    
                    //valores seleccionados esperando a ser ejecutados cuando se pulse Empezar
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        switch((int) newValue){ 
                            case 0:
                                valor = 0;
                                System.out.println("Pequeño");
                                casillaX = 3;
                                casillaY = 4;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                
                                Hbox1.setVisible(false);
                                break;
                                
                            case 1:
                                valor = 0;
                                System.out.println("Mediano");
                                casillaX = 10;
                                casillaY = 10;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                
                                Hbox1.setVisible(false);
                                break;
                            case 2:
                                valor = 0;
                                System.out.println("Grande");
                                casillaX = 15;
                                casillaY = 15;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                
                                Hbox1.setVisible(false);
                                break;
                                
                            case 3:
                                valor = 1;
                                System.out.println("Personalizado");
                                
                                Hbox1.setVisible(true);
                                break;
                        }
                    }
                });
                // crear fondo
                Separator separatorWallpaper = new Separator();
                Label labelWallpaper = new Label("Seleccionar fondo");
                Button buttonWallpaper = new Button();
                buttonWallpaper.setText("Seleccionar fondo");
                buttonWallpaper.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Seleccionar imagen");

                        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                        FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
                        FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
                        fileChooser.getExtensionFilters().addAll(extFilterPNG);
                        fileChooser.getExtensionFilters().addAll(extFilterJPG);
                        fileChooser.getExtensionFilters().addAll(extFilterJPEG);
                        fileChooser.getExtensionFilters().addAll(extFilterGIF);
                        File file = fileChooser.showOpenDialog(null);
                        localUrl = null;
                        try {
                            localUrl = file.toURI().toURL().toString();
                        }
                        catch (MalformedURLException ex) {
                            Logger.getLogger(Pantalla.SameDAW.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                });
                
                //Activar/desactivar líneas
                Separator separator2 = new Separator();
                Label labelLines = new Label("Lineas");
                CheckBox cbl = new CheckBox("Activar Lineas");
                cbl.setSelected(true);
                
                Button buttonEmpezar = new Button();
                buttonEmpezar.setText("Empezar");
                // Boton empezar. Literalmente todo occure aquí
                buttonEmpezar.setOnAction(new EventHandler<ActionEvent>() {
                //Se aplica los valores de personalizado
                    public void handle(ActionEvent event) {
                        switch((int) valor){
                            case 1:
                                if (textField.getText().trim().isEmpty()) {
                                    System.out.println("Vacio1");
                                    casillaX = 10;
                                    finalCasillaX = tamanoCasilla*casillaX;
                                }
                                else if(textField.getText() !=null){
                                    System.out.println("Lleno1");

                                    int Inum = Integer.valueOf(textField.getText());
                                    casillaX = Inum;
                                    finalCasillaX = tamanoCasilla*casillaX;
                                }
                                // Segundo textField
                                if (textField2.getText().trim().isEmpty()) {
                                    System.out.println("Vacio2");
                                    casillaY = 10;
                                    finalCasillaY = tamanoCasilla*casillaY;
                                }
                                else if(textField2.getText() !=null){
                                    System.out.println("Lleno2");
                                    int Inum = Integer.valueOf(textField2.getText());
                                    casillaY = Inum;
                                    finalCasillaY = tamanoCasilla*casillaY;
                                    
                                }
                            break;
                        }
                        //
                        if (localUrl !=null){
                            Image image = new Image(localUrl);
                            imageView = new ImageView(image);
                            imageView.setFitHeight(finalCasillaY);
                            imageView.setFitWidth(finalCasillaX);
                        }

                        if (imageView != null){
                            root.getChildren().add(imageView);
                            System.out.println("imagen :D");
                        }
                        
                        //
                        dimensionX=finalCasillaX+3;
                        dimensionY=finalCasillaY+70;
                        
                        if (cbl.isSelected()){
                            ArrayList<Line> listaLinea = new ArrayList();
                            for (int i = 0; i < finalCasillaX; i+= tamanoCasilla) {
                                line = new Line();
                                line.setStartX(i);
                                line.setEndX(i);
                                line.setStartY(0);
                                line.setEndY(finalCasillaY);
                                line.setStroke(Color.WHITE);            
                                listaLinea.add(line);
                                root.getChildren().add(line);
                            }
                            for (int i = 0; i < finalCasillaY; i+= tamanoCasilla) {
                                line2 = new Line();
                                line2.setStartX(0);
                                line2.setEndX(finalCasillaX);
                                line2.setStartY(i);
                                line2.setEndY(i);
                                line2.setStroke(Color.WHITE);
                                listaLinea.add(line2);
                                root.getChildren().add(line2);
                            }
                        }
                        primaryStage.setWidth(dimensionX);
                        primaryStage.setHeight(dimensionY);
                        // Asignacion y aplicacion de tablero
                        getTablero();
                        mostrarMatriz();
                        
                        newWindow.close();   
                    }
                });
                //Elementos metidos en Cajas
                root2.getChildren().add(Hbox1);
                VBox vbox= new VBox(label2,choiceBox,Hbox1,separatorWallpaper,labelWallpaper,buttonWallpaper,separator2,labelLines,cbl,buttonEmpezar);
                
                root2.getChildren().add(vbox);
                
            }
        });
        MenuItem menuItem2 = new MenuItem("Salir");
        menuItem2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                primaryStage.close();
            }
        });
        Menu menu3 = new Menu("Ayuda");
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menu3);
        menuBar.setMinWidth(dimensionX);
        //menuItem
        // HBOX de abajo
        Label label3 = new Label("Puntuacion:");
        
        Label label9 = new Label(dato+" Bolas Seleccionadas("+multiplicador+" puntos)");
        HBox hbox = new HBox(label9,label3);
        hbox.setSpacing(60);
        hbox.setMinHeight(10);
        hbox.setMinWidth(dimensionX);
        
        
        // HBOX de abajo
        
        //bordes
        border.setTop(menuBar);
        border.setCenter(root);
        border.setBottom(hbox);
        
        //bordes
        

        Scene scene = new Scene(border,dimensionX, dimensionY,Color.web("#000000"));
        primaryStage.setWidth(dimensionX);
        primaryStage.setHeight(dimensionY);
        border.setStyle("-fx-background-color: transparent;");
        hbox.setStyle("-fx-background-color: white;");
        primaryStage.setTitle("SameDAW");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
