package view;

import controller.*;
import java.io.IOException;
import model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX application example - User array in TableView objects
 *
 * @author Juha Peltomäki
 *
 * This is an source code example and is provided as-is without any warranty
 */
public class UsersTableDemo extends Application {

    BorderPane mainLayout;
    private ObservableList<User> userList
            = FXCollections.observableArrayList();

    public UsersTableDemo() {
        // add some data to UserList element
        userList.add(
                new User("jack", 40, 11, 10, 1973));
        userList.add(
                new User("johnny", 22, 27, 11, 1991));
        userList.add(
                new User("jill", 47, 5, 6, 1966));
        userList.add(
                new User("jane", 41, 12, 6, 1972));
        userList.add(
                new User("mika", 28, 5, 5, 1985));
        userList.add(
                new User("juha", 44, 1, 4, 1969));
        userList.add(
                new User("pasi", 42, 12, 10, 1971));
        userList.add(
                new User("brigitte", 56, 1, 5, 1957));
    }

    /**
     * JavaFX view classes always should be informed about changes made to
     * userList. Then the view would be always in sync with the data. JavaFX has
     * new collection class for that called javafx.collections.ObservableList.
     *
     * @return observable list of Users
     */
    public ObservableList<User> getUserList() {
        return userList;
    }

    // Starting of the javaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX TableView demo");
        mainLayout = new BorderPane();

        Scene scene = new Scene(mainLayout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        // Now add tableview component to main layout
        showUsers();
    }

    /**
     * Loads the FXML file and set the user list.
     */
    public void showUsers() {
        System.out.println(userList);
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader fxmlLoader = new FXMLLoader(
                    UsersTableDemo.class.getResource("/view/users.fxml"));
            AnchorPane userPage = (AnchorPane) fxmlLoader.load();
            mainLayout.setCenter(userPage);

            // Set into Controller access to main application
            controller.UsersController controller
                    = fxmlLoader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
