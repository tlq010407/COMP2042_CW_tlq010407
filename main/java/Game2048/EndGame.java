package Game2048;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.io.*;
import java.util.Optional;

import static Game2048.Main.HEIGHT;
import static Game2048.Main.WIDTH;
import static java.lang.System.exit;

/**
 * This class is used to decpribe when whole game is over.
 */
public class EndGame extends Record{
    private static EndGame singleInstance = null;
    private int score;
    private EndGame() {
    }

    public static EndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    /**
     * Parameters setting for the end game scene.
     * @param endGameScene stores the all parameters of the end game scene.
     * @param root
     * @param primaryStage set the end game scene show in the screen.
     * @param score is the final score when game is ended.
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, int score) {
        this.score = score;
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);
        gethighscore();
        checkscore(score);

        Text scoreText = new Text("Score: "+ score);
        Text highscoreText = new Text("Highest Score: "+gethighscore());
        scoreText.setFill(Color.BLACK);
        highscoreText.setFill(Color.BLACK);
        scoreText.relocate(250, 400);
        highscoreText.relocate(250,500);
        scoreText.setFont(Font.font(50));
        highscoreText.setFont(Font.font(50));
        root.getChildren().add(scoreText);
        root.getChildren().add(highscoreText);

        /**
         * Restart Button:
         * when user click this button, the scene will switch to the game scene.
         */
        Button restart = new Button("Try Again!");
        restart.setPrefSize(100,30);
        restart.setTextFill(Color.BLACK);
        root.getChildren().add(restart);
        restart.relocate(100,700);
        restart.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
                Group gameRoot = new Group();
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
                primaryStage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, primaryStage, endGameScene, root);
                root.getChildren().clear();
            }
        });

        /**
         * Set a popup window to show the final score.
         */
        Stage showscore = new Stage();
        showscore.initModality(Modality.APPLICATION_MODAL);
        showscore.setTitle("Game Over: ");
        Label finalscore = new Label("Your Final Score is:\n" + score);
        finalscore.setFont(Font.font(30));
        Button button1 = new Button("Close");
        button1.setOnAction(e -> showscore.close());
        VBox layout= new VBox(20);
        layout.getChildren().addAll(finalscore, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        showscore.setScene(scene1);
        showscore.showAndWait();

        /**
         * A Alert:
         * Pop up a screen and ask whether user wanna quit game or not,
         * if user click "OK",
         * then the game will close the whole game screen automatically.
         */
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            root.getChildren().clear();
            /**
             * Automaticlly colse the game window when Ok button is clickes.
             */
            exit(0);
        }

        //delete the quitButton here, and add the popup window to show the final score
    }
}
