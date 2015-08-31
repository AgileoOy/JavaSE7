package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import view.UsersTableDemo;

/**
 * FXML Controller class
 *
 * @author Juha Peltomäki
 */
public class UsersController implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, Integer> ageColumn;
    @FXML
    private TableColumn<User, String> birthdayColumn;
    // Reference to the main application
    private UsersTableDemo mainApplication;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // In the User class should be properties name, age and borndate.
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<User, String>("borndate"));
    }

    /**
     * Method is called by the main application
     *
     * @param main
     */
    public void setMainApp(UsersTableDemo main) {
        this.mainApplication = main;
        // Add observable list data to the table
        tableView.setItems(this.mainApplication.getUserList());

    }
}
