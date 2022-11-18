package Game2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXML;

/**
 * Controller for Start.fxml:
 * This class is used to add start, and menu screen,
 * and this class is combined with the pane package to achieve the switch the scene.
 */
public class StartController{
    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    /**
     * When the start button clicked, switch to the menu scene.
     * @param event
     * @throws IOException
     */
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Pane/Menu.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private TextField txt1;
    /**
     * Get the user's name,
     * if user didn't enter their name, alert will be shown to ask them to enter their name.
     * @param event
     * @throws IOException
     */
    @FXML
    public void getname(ActionEvent event) throws IOException {
        if (txt1.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT");
            alert.setHeaderText("EMPTY USER NAME");
            alert.setContentText("Please Enter Your User Name");
            alert.getDialogPane().getButtonTypes();
            alert.showAndWait();
        }else {
            String name = txt1.getText();
            Account account = new Account(name);
            switchToMenu(event);
        }
    }
}

