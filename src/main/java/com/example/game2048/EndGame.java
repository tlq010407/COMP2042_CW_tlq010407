package com.example.game2048;

import com.example.game2048.Component.Buttons;
import com.example.game2048.Highest.Record;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;

import static com.example.game2048.Highest.Account.getUserName;

/**
 * This class is used to describe when whole game is over.
 * @author liqi tang-modified
 */
public class EndGame extends Record{
    private static EndGame singleInstance = null;

    public EndGame(){
    }
    public static EndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    /**
     * Parameters setting for the end game scene.
     * @param endGameScene stores the all parameters of the end game scene.
     * @param root the group root.
     * @param primaryStage set the end game scene show in the screen.
     * @param score is the final score when game is ended.
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, int score){
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);
        readFile(scoreFile);
        checkscore(score,getUserName()); //check whether the current score is higher than the highest score.

        //lay out the current username, current score, the highest score, and highest score username on scene.
        Text userName = new Text("Player: " + getUserName());
        Text scoreText = new Text("Score: "+ score);
        Text highscoreText = new Text("Highest Score: "+ getHighscore());
        Text RecordUser = new Text("Highest Score User: "+ getHighscoreUser());
        userName.setFill(Color.BLACK);
        scoreText.setFill(Color.BLACK);
        highscoreText.setFill(Color.BLACK);
        RecordUser.setFill(Color.BLACK);
        userName.relocate(250,350);
        scoreText.relocate(250, 425);
        highscoreText.relocate(250,500);
        RecordUser.relocate(250,575);
        userName.setFont(Font.font(40));
        scoreText.setFont(Font.font(40));
        highscoreText.setFont(Font.font(40));
        RecordUser.setFont(Font.font(40));
        root.getChildren().add(userName);
        root.getChildren().add(scoreText);
        root.getChildren().add(highscoreText);
        root.getChildren().add(RecordUser);

        HBox endgamebuttons = new HBox(80); //using HBox to manage position of all the buttons on the endgame scene.
        endgamebuttons.setLayoutY(700);
        endgamebuttons.setLayoutX(200);

        //Addition:
        //Restart Button:
        //when user click this button, the scene will switch to the game scene.
        Button restart = new Button("Try Again!");
        restart.setTextFill(Color.BLACK);
        root.getChildren().add(restart);
        restart.setOnMouseClicked(event -> Buttons.restarted(root, primaryStage, endGameScene));

        //Addition:
        //Back Menu Button:
        //when user click this button, the scene will switch to the menu scene.
        Button backmenu = new Button("Back to Menu");
        backmenu.setTextFill(Color.BLACK);
        root.getChildren().add(backmenu);
        backmenu.setOnMouseClicked(new EventHandler<>() {
            public void handle(MouseEvent event) {
                Parent menuRoot;
                try {
                    menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage menuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene menuScene = new Scene(menuRoot);
                menuStage.setScene(menuScene);
                root.getChildren().clear();
                menuStage.show();
            }
        });

        //Addition:
        // if other user want to play this game,
        //they can just enter their name without exit the game through this button.
        Button accountButton = new Button("New Player");
        accountButton.setTextFill(Color.BLACK);
        root.getChildren().add(accountButton);
        accountButton.setOnMouseClicked(mouseEvent -> Buttons.newPlayer(root, primaryStage, endGameScene));

         //Alert:
         // Pop up a screen and ask whether user want to quit game or not,
         //if user click "OK",
         // then the game will close the whole game screen automatically.
        Button quitButton = new Button("QUIT");
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.setOnMouseClicked(event -> Buttons.quit(root));

        Button rankButton = new Button("RANK");
        rankButton.setTextFill(Color.BLACK);
        root.getChildren().add(rankButton);
        rankButton.setOnMouseClicked(mouseEvent -> Buttons.goRank(primaryStage));

        HBox.setHgrow(restart, Priority.ALWAYS);
        HBox.setHgrow(backmenu, Priority.ALWAYS);
        HBox.setHgrow(accountButton, Priority.ALWAYS);
        HBox.setHgrow(quitButton, Priority.ALWAYS);
        HBox.setHgrow(rankButton, Priority.ALWAYS);
        restart.setMaxWidth(Double.MAX_VALUE);
        backmenu.setMaxWidth(Double.MAX_VALUE);
        accountButton.setMaxWidth(Double.MAX_VALUE);
        quitButton.setMaxWidth(Double.MAX_VALUE);
        rankButton.setMaxWidth(Double.MAX_VALUE);
        endgamebuttons.getChildren().addAll(restart,backmenu,accountButton, rankButton, quitButton);
        root.getChildren().add(endgamebuttons);

    }
}
