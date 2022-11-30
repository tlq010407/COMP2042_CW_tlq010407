package Game2048.Component;

import Game2048.GameScene;
import Game2048.Highest.Account;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Optional;

import static Game2048.Main.HEIGHT;
import static Game2048.Main.WIDTH;
import static Game2048.MenuController.color;
import static java.lang.System.exit;

/**
 * This class is used to contain several ventHandler<MouseEvent> functions.
 */
public class Buttons{
    /**
     * Restart:
     *     when user click this button, the scene will switch to the game scene.
     * @param root the scene root.
     * @param primaryStage the primary stage of the game.
     * @param endGameScene the scene.
     */
    public static void restarted(Group root, Stage primaryStage, Scene endGameScene) {
                Group gameRoot = new Group();
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, color);
                primaryStage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, primaryStage, endGameScene, root, color);
                root.getChildren().clear();
    }
    //Addition:
    //

    /**
     *  enter name:
     *  if other user want to play this game,
     *  they can just enter their name without exit the game through this button.
     * @param root the scene root.
     * @param primaryStage the primary stage of the game.
     * @param endGameScene the scene.
     */
    public static void newPlayer(Group root, Stage primaryStage, Scene endGameScene) {
                TextInputDialog namedialog = new TextInputDialog();
                namedialog.setHeaderText("enter your name");
                namedialog.setContentText("NAME:");
                Optional<String> result = namedialog.showAndWait();
                Account account = new Account(result.get());
                root.getChildren().clear();

                Group gameRoot = new Group();
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
                primaryStage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, primaryStage, endGameScene, root, color);
    }
    /**
     * A Alert:
     * Pop up a screen and ask whether user wanna quit game or not,
     * if user click "OK",
     * then the game will close the whole game screen automatically.
     */
    public static void quit(Group root) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            root.getChildren().clear();
            exit(0);
        }
    }
}
