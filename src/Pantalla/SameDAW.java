/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
    @Override
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
                "Pequeño", "mediano", "Grande", "Personalizado"));
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
                
                
                
                choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        switch((int) newValue){
                            case 0:
                                System.out.println("Pequeño");
                                Hbox1.setVisible(false);
                                casillaX = 3;
                                casillaY = 3;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                break;
                                
                            case 1:
                                System.out.println("Mediano");
                                Hbox1.setVisible(false);
                                casillaX = 10;
                                casillaY = 10;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                break;
                            case 2:
                                
                                System.out.println("Grande");
                                Hbox1.setVisible(false);
                                casillaX = 15;
                                casillaY = 15;
                                primaryStage.setWidth(dimensionX);
                                primaryStage.setHeight(dimensionY);
                                finalCasillaX = tamanoCasilla*casillaX;
                                finalCasillaY = tamanoCasilla*casillaY;
                                break;
                                
                            case 3:
                                System.out.println("Personalizado");
                                    if (textField.getText().trim().isEmpty()) {
                                        System.out.println("Vacio1");
                                        casillaX = 15;
                                        finalCasillaX = tamanoCasilla*casillaX;
                                    }
                                    else{
                                        System.out.println("Lleno1");

                                        int Inum = Integer.valueOf(textField.getText());
                                        casillaX = Inum;
                                        finalCasillaX = tamanoCasilla*casillaX;
                                    }
                                                        // Segundo textField
                                    if (textField2.getText().trim().isEmpty()) {
                                        System.out.println("Vacio2");
                                        casillaY = 15;
                                        finalCasillaY = tamanoCasilla*casillaY;
                                    }
                                    else{
                                        System.out.println("Lleno2");
                                        int Inum = Integer.valueOf(textField2.getText());
                                        casillaY = Inum;
                                        finalCasillaY = tamanoCasilla*casillaY;
                                    }
                                    Hbox1.setVisible(true);
                                break;
                        }
                    }
                });
                
                Button button2 = new Button();
                button2.setOnAction(new EventHandler<ActionEvent>() {
                    
                    public void handle(ActionEvent event) {
                        
                        dimensionX=finalCasillaX+3;
                        dimensionY=finalCasillaY+70;

                        primaryStage.setWidth(dimensionX);
                        primaryStage.setHeight(dimensionY);
                        
                        for (int i = 0; i < finalCasillaX; i+= tamanoCasilla) {
                            Line line = new Line();
                            line.setStartX(i);
                            line.setEndX(i);
                            line.setStartY(0);
                            line.setEndY(finalCasillaY);
                            line.setStroke(Color.WHITE);
                            root.getChildren().add(line);
                        }
                    // horizontal
                        for (int i = 0; i < finalCasillaY; i+= tamanoCasilla) {
                            Line line = new Line();
                            line.setStartX(0);
                            line.setEndX(finalCasillaX);
                            line.setStartY(i);
                            line.setEndY(i);
                            line.setStroke(Color.WHITE);
                            root.getChildren().add(line);
                        }
                        newWindow.close();
                    }
                    
                });
                
                Separator separator1 = new Separator();
                
                button2.setText("Empezar");
                root2.getChildren().add(Hbox1);
                VBox vbox= new VBox(label2,choiceBox,Hbox1,separator1,button2);
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
