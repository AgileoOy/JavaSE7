package fi.agileo.fxdemos;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.event.*;
 
public class PainikkeenTapahtumanKasittely extends Application {
 
   @Override
   public void start(Stage nayttamo) {

       Group juuri = new Group();
       Scene skene = new Scene(juuri, 500, 500, Color.BLACK);
 
       final Circle ympyra = new Circle(50, 50, 50); 
       ympyra.setFill(Color.RED);
       //juuri.getChildren().add(ympyra);

       Button painike = new Button("Punainen");
       painike.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ympyra.setFill(Color.RED);
            }
       });

       Button painike2 = new Button("Vihrea");
       painike2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ympyra.setFill(Color.GREEN);
            }
       });

       HBox laatikko = new HBox();
       laatikko.getChildren().addAll(painike, painike2, ympyra);
       laatikko.setSpacing(20);
       

       juuri.getChildren().add(laatikko);
 
       nayttamo.setTitle("JavaFX - Painikkeen klikkauksen käsittely");
       nayttamo.setScene(skene);
       nayttamo.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}