package fi.agileo.fxdemos;
/**
 * JavaFX example - shows and changed some text in label components
 *
 * @author Juha Peltomäki
 *
 */


import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LabelsDemo extends Application {

    VBox layout;
    final Button selectButton = new Button("Change Labels");
    final int labelCount = 10;
    ObservableList<String> fruits;
    Label[] labels;
    Color[] colors;
    static int currentSelection, loops;

    // The starting the javaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Label demo");
        labels = new Label[labelCount];
        colors = new Color[labelCount];
        for (int i = 0; i < labelCount; i++) {
            int k = i + 1;
            labels[i] = new Label("Label: " + (i + 1));
            colors[i] = Color.rgb(255 - k * 25, k * 25, 127 + k * 12);
        }
        currentSelection = 0;
        loops = 1;

        fruits = FXCollections.observableArrayList(
                "Apple",
                "Orange",
                "Banana",
                "Pear",
                "Grape",
                "Kiwi",
                "Pineapple",
                "Nectarine",
                "Peach",
                "Mango");

        initEventHandling();

        layout = new VBox();
        for (Label label : labels) {
            layout.setSpacing(10);
            layout.getChildren().add(label);
        }
        layout.getChildren().add(selectButton);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initEventHandling() {

        selectButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                loops = (currentSelection < labelCount - 1) ? loops : loops + 1;
                currentSelection = (currentSelection < labelCount - 1)
                        ? currentSelection + 1 : 0;

                labels[currentSelection].setText("Loops: " + loops + ", Current Index: "
                        + currentSelection + "," + fruits.get(currentSelection));
                labels[currentSelection].setTextFill(colors[currentSelection]);
                //System.out.println("sel: " + currentSelection);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
