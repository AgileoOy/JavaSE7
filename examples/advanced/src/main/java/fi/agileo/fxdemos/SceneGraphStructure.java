package fi.agileo.fxdemos;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** JavaFX sovellus periytyy Application luokasta
 *
 */
public class SceneGraphStructure extends Application {
        // starting the JavaFX application
        @Override
        public void start(Stage primaryStage) {

            // Setting the title and adding a button with event handling
            primaryStage.setTitle("Hello JavaFX!");
            Button button = new Button();
            button.setText("JavaFX - use it instead of Swing!");
            final Label label = new Label();
            label.setText("You see result in here");
            

            button.setOnAction(                
                new EventHandler() {
                @Override
                public void handle(Event t) {
                   System.out.println("A button was clicked!");
                   label.setText("A button was clicked!");
                }
            });

             //Adding components to StackPane
            final BorderPane borderLayout = new BorderPane();
            
            borderLayout.setLeft(button);
            borderLayout.setRight(label);
            //Adding StackPane to main window (scene)
            Scene scene = new Scene(borderLayout, 350, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        /**
        * The main() method is ignored in correctly deployed JavaFX
         * application. main() serves only as fallback in case the application
         * can not be launched through deployment artifacts, e.g., in IDEs with
         * limited FX support. NetBeans ignores main().
        */
        public static void main(String[] args) {
            launch(args);
        }
    }