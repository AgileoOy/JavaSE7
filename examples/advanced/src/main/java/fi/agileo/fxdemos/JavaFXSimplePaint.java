package fi.agileo.fxdemos;
/**
 * Example: Simple painting application with JavaFX
 *
 * @author Juha Peltomäki
 *
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXSimplePaint extends Application {

    private static int clickCounter = 0;

    @Override
    public void start(Stage primaryStage) {

        Group groupRoot = new Group();
        Canvas canvas = new Canvas(300, 250);
        groupRoot.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Rectangle rect = new Rectangle(0, 0, 300, 300);
        rect.setFill(Color.AZURE);
        groupRoot.getChildren().add(rect);

        drawShapes(gc, groupRoot);

        Scene scene = new Scene(groupRoot, 400, 350);
        primaryStage.setTitle("Painting in JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc, final Group group) {

        group.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                Arc circle = new Arc();
                circle.setCenterX(me.getX());
                circle.setCenterY(me.getY());
                circle.setRadiusX(clickCounter + 10);
                circle.setRadiusY(clickCounter + 10);
                circle.setStartAngle(0.0f);
                circle.setLength(90.0f + clickCounter * 10);
                circle.setType(ArcType.ROUND);
                circle.setFill(Color.CHOCOLATE);
                group.getChildren().add(circle);
                clickCounter++;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
