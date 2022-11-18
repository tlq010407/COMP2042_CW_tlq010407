package Game2048;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    /**
     * When start game button is clicked, switch to the game scene.
     * @param event
     * @throws IOException
     */

    @FXML
    private TextField txt1;
    /**
     * Get the Username from the textfield.
     * @param getname
     * @throws IOException
     */
    @FXML
    public void getname(ActionEvent getname) throws IOException {
        String name = txt1.getText();
        Account account = new Account(name);
        switchToMenu(getname);
    }
}
