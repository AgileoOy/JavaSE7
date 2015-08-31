package fi.agileo.fxdemos;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.animation.*; 
import javafx.util.Duration; 
 
public class Animointi extends Application {
 
    @Override
    public void start(Stage nayttamo) {

        Group juuri = new Group();
        Scene skene = new Scene(juuri, 500, 500, Color.BLACK);

        Rectangle suorakulmio = new Rectangle(50, 50, 200, 200);
       suorakulmio.setFill(Color.GREEN);
       juuri.getChildren().add(suorakulmio);

        Circle ympyra2 = new Circle(250, 250, 50); 
        ympyra2.setFill(Color.RED);
        juuri.getChildren().add(ympyra2);

        TranslateTransition siirra = new TranslateTransition(Duration.millis(1000)); 
        siirra.setToX(100); 
        siirra.setToY(150); 

        ScaleTransition skaalaa = new ScaleTransition(Duration.millis(1000)); 
        skaalaa.setToX(0.5); 
        skaalaa.setToY(0.5); 

        RotateTransition pyorita = new RotateTransition(Duration.millis(1000)); 
        pyorita.setToAngle(360); 

        FillTransition varita = new FillTransition(Duration.millis(1000)); 
        varita.setToValue(Color.BLUE);

        ParallelTransition siirtyma = new ParallelTransition(suorakulmio, siirra, skaalaa, pyorita, varita); 
        siirtyma.setCycleCount(Timeline.INDEFINITE);
        siirtyma.setAutoReverse(true); 
        siirtyma.play(); 

        nayttamo.setTitle("JavaFX - Animointidemo");
        nayttamo.setScene(skene);
        nayttamo.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}

