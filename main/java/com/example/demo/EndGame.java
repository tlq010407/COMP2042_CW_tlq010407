package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

import static java.lang.System.exit;

/**
 * This class is used to decpribe when whole game is over.
 */
public class EndGame {
    private static EndGame singleInstance = null;
    private long score;
    private long highest;

    public void setHighest(long highest) {
        this.highest = highest;
    }

    public long getHighest() {
        return highest;
    }

    private EndGame() {
        if (this.score > this.highest){
            this.highest = this.score;
        }
    }

    public static EndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    /**
     *
     * @param endGameScene
     * @param root
     * @param primaryStage
     * @param score is the final score when game is ended.
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, long score) {
        this.score = score;
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);


        Text scoreText = new Text("score:"+ score + "\nheighest score:"+ highest);
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(200, 500);
        scoreText.setFont(Font.font(50));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100, 30);
        quitButton.setTextFill(Color.PINK);
        root.getChildren().add(quitButton);
        quitButton.relocate(100, 800);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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
            }
        });


    }
}
