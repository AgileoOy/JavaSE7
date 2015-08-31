package fi.agileo.fxdemos;
/**
 * JavaFX example - shows different layout models in JavaFX
 *
 * @author Juha Peltomäki
 *
 */

import java.util.Arrays;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutTest extends Application {

    Button[] buttons;
    Scene scene;
    BorderPane mainLayout;
    final Button selectButton = new Button("Change layout");
    final Pane[] layouts = {new FlowPane(), new HBox(), new TilePane(), new VBox(), new GridPane()};
    final String layoutNames[] = {"FlowPane", "HBox", "TilePane", "VBox", "GridPane"};
    Label[] labels = new Label[5];
    final int buttonCount = 10, layoutCount = 5;
    static int currentSelection;

    // The starting the javaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Layouts demonstration");
        buttons = new Button[buttonCount];
        for (int i = 0; i < buttonCount; i++) {
            buttons[i] = new Button("Button " + (i + 1) + ".");
        }

        for (int i = 0; i < layoutCount; i++) {
            labels[i] = new Label(layoutNames[i]);
        }

        currentSelection = 0;

        initEventHandling();

        mainLayout = new BorderPane();
        mainLayout.setCenter(new Label("See changed in here!"));
        mainLayout.setBottom(selectButton);
        scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initEventHandling() {
        selectButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("sel: " + currentSelection);
                currentSelection = (currentSelection < layoutCount - 1)
                        ? currentSelection + 1 : 0;

                System.out.println("sel: " + currentSelection);
                changeLayout();
            }
        });
    }

    public void changeLayout() {
        layouts[currentSelection].getChildren().clear();
        if (currentSelection < layoutCount - 1) {
            layouts[currentSelection].getChildren()
                    .addAll(Arrays.asList(buttons));
            layouts[currentSelection].getChildren()
                    .add(labels[currentSelection]);
        } else {
            for (int i = 0; i < buttonCount; i++) {
                ((GridPane) layouts[layoutCount - 1])
                        .add(buttons[i], i % 3, i / 3);
            }
            ((GridPane) layouts[layoutCount - 1])
                    .add(labels[currentSelection], 3, 2);
        }
        mainLayout.setCenter(layouts[currentSelection]);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
