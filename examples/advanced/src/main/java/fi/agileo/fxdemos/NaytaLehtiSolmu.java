package fi.agileo.fxdemos;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.*;
 
public class NaytaLehtiSolmu extends Application {
 
   @Override
   public void start(Stage nayttamo) {

       Group juuri = new Group();
       Scene skene = new Scene(juuri, 500, 500, Color.BLACK);
 
       Rectangle suorakulmio = new Rectangle(50, 50, 200, 200);
       suorakulmio.setFill(Color.GREEN);
       juuri.getChildren().add(suorakulmio);

       Circle ympyra = new Circle(50, 50, 50); 
       ympyra.setFill(Color.RED);
       juuri.getChildren().add(ympyra);


       Circle ympyra2 = new Circle(250, 250, 50); 
       ympyra2.setFill(Color.RED);
       juuri.getChildren().add(ympyra2);

 
       nayttamo.setTitle("JavaFX - Näytä kaksi lehti solmua");
       nayttamo.setScene(skene);
       nayttamo.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}