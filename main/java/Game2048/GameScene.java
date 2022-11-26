package Game2048;

import Game2048.Component.Cell;
import Game2048.Moving.Move;
import Game2048.Component.Survival;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is a class that contains all game scenes.
 */

public class GameScene extends Move {
    private final static int distanceBetweenCells = 10;
    public static int HEIGHT = 700;
    public static int haveEmptyCell;
    private static final double LENGTH = (HEIGHT - ((cellNum + 1) * distanceBetweenCells)) /(double)cellNum;
    public static double getLENGTH() {
        return LENGTH;
    }

    /**
     * Check whether is an empty cell or not.
     * @return 1 if there still get empty cells; 0 if the user already win; -1 if there is no more empty cell.
     */
    private int haveEmptyCell() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (cells[i][j].getNumber() == 2048) {
                    return 0;
                }else if (cells[i][j].getNumber() == 0) {
                    return 1;
                }
            }
        }
        return -1;
    }

    /**
     * Check if there have same numbers nearly that user can continue the game.
     * @param i is position in the row.
     * @param j is the position in the colum.
     * @return boolean as a result.
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < cellNum - 1 && j < cellNum - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }

    /**
     * Check whether user can still move ot mot.
     * @return the boolean as a result.
     */
    private boolean canNotMove() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Show the final score through pop up window after ending the game.
     */
    public void showScore(){
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
    }
    /**
     * Set the game scene, add all the cells on.
     *
     * @param gameScene    contains the basic parameters in game scene, like background color.
     * @param root         the game scene root.
     * @param primaryStage set the game scene as the primary stage.
     * @param endGameScene when game ended, switch to the end game scene.
     * @param endGameRoot  the root of the game scene.
     * @param color the background color.
     */
    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot, Color color) {
        //Check the Mode.
        if (Mode.equals("Survival")){
            Text timelabel = new Text();
            timelabel.setFont(Font.font(30));
            timelabel.setFill(Color.RED);
            timelabel.relocate(730, 200);
            Survival.doTime(timelabel);
            root.getChildren().add(timelabel);
        }
        //change the game scene background color.
        gameScene.setFill(color);
        this.root=root;
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        // Set the position of the score shows in the game scene.
        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        //randomly filling two number at the beginning of the game.
        randomFillNumber();
        randomFillNumber();

        //Capture the keyboard action and do the corresponding movements in game scene.
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            if (key.getCode() == KeyCode.DOWN) {
                GameScene.this.moveDown();
            } else if (key.getCode() == KeyCode.UP) {
                GameScene.this.moveUp();
            } else if (key.getCode() == KeyCode.LEFT) {
                GameScene.this.moveLeft();
            } else if (key.getCode() == KeyCode.RIGHT) {
                GameScene.this.moveRight();
            }else {
                return;
            }
            scoreText.setText(score + "");
            haveEmptyCell = GameScene.this.haveEmptyCell();
            if (haveEmptyCell == -1 || Survival.seconds<=0 || haveEmptyCell == 0) {         //if there is no empty cell or times up or users reach the 2048 cell, then end the game
                if (GameScene.this.canNotMove() || Survival.seconds<=0 || haveEmptyCell == 0) {     //if there is no empty cell or times up or users reach the 2048 cell, then end the game
                    //Set a popup window to show the final score.
                    showScore();
                    //if users cannot move anymore, then switch to the end game scene
                    primaryStage.setScene(endGameScene);
                    EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                    root.getChildren().clear();
                    score = 0;
                    Survival.seconds = 20;
                }
            } else if (GameScene.this.getChanged()) {        // if there are some movements happens on cells, then generating random numbers and filling in an empty cell.
                GameScene.this.randomFillNumber();
                setChanged(false);       // set the 'changed' back to false.
            }
        }));
    }
}
