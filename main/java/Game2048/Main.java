package Game2048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @auther  Tang,Liqi
 * @version 9.0
 */
public class Main extends Application{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception { //no need test
        //set the default primary stage as start scene.
        Parent root = FXMLLoader.load(getClass().getResource("Pane/Start.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
