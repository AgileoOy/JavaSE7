package fi.agileo.fxdemos;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ListDemo extends Application {

    VBox verticalBox;
    Label label;
    ListView<String> list;
    ObservableList<String> fruits;

    // The starting the javaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ListView example");
        label = new Label();
        verticalBox = new VBox();
        list = new ListView<>();

        fruits = FXCollections.observableArrayList(
                "Apple",
                "Orange",
                "Banana",
                "Pear",
                "Grape",
                "Kiwi",
                "Pineapple");

        list.setItems(fruits);
        initEventHandling();

        verticalBox.getChildren().addAll(list, label);
        Scene scene = new Scene(verticalBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initEventHandling() {

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
               int selectionIndex = list.getSelectionModel().getSelectedIndex();
                 String selectedText = list.getSelectionModel().getSelectedItem();
                 label.setText(selectedText + ", Index: " + selectionIndex);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}