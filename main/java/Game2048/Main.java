package Game2048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @auther Tang, Liqi
 * @version 4.0
 */
public class Main extends Application{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public Group gameRoot = new Group();
    public Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Pane/Start.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
