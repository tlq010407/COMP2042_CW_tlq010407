package Game2048;

import Game2048.Component.Cell;
import Game2048.Component.Survival;
import Game2048.Moving.CheckCellStatus;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
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

/**
 * This is a class that contains all game scenes.
 */
public class GameScene extends CheckCellStatus {
    /**
     * Show the final score through pop up window after ending the game.
     */
    private void showScore(String title){
        Stage showscore = new Stage();
        showscore.initModality(Modality.APPLICATION_MODAL);
        showscore.setTitle(title);
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
     * Switch to the end game scene.
     * @param primaryStage the primary stage which will be shown.
     * @param endGameScene the end game scene.
     * @param endGameRoot the end game root.
     */
    private void SetScene(Stage primaryStage, Scene endGameScene, Group endGameRoot){
        primaryStage.setScene(endGameScene);
        EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
        root.getChildren().clear();
        score = 0;
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
            int haveEmptyCell;
            haveEmptyCell = GameScene.this.haveEmptyCell();
            if (haveEmptyCell == -1 || Survival.seconds<=0 || haveEmptyCell == 0) {         //if there is no empty cell or times up or users reach the 2048 cell, then end the game
                if (GameScene.this.canNotMove()) {     //if there are no more cells can be merged.
                    //Set a popup window to show the final score while user lose the game.
                    showScore("Game Over:");
                    SetScene(primaryStage, endGameScene, endGameRoot);
                } else if (Survival.seconds<=0) {       //if times up
                    //Set a popup window to show the final score while times up.
                    showScore("Times Up:");
                    SetScene(primaryStage, endGameScene, endGameRoot);
                    Survival.seconds = 20;
                } else if (haveEmptyCell == 0) {        //if users reach the 2048 cell, then end the game.
                    //Set a popup window to show the final score while user reach the 2048 goal.
                    showScore("You Win:");
                    //if user reach the 2048 goal, then show user win the game pop-up window.
                    Stage showscore = new Stage();
                    showscore.initModality(Modality.APPLICATION_MODAL);
                    showscore.setTitle("You Win: ");
                    Label finalscore = new Label("Congradulations!!!\n You Win the Game!!!!");
                    finalscore.setFont(Font.font(30));
                    Button button1 = new Button("Close");
                    button1.setOnAction(e -> showscore.close());
                    VBox layout= new VBox(20);
                    layout.getChildren().addAll(finalscore, button1);
                    layout.setAlignment(Pos.CENTER);
                    Scene scene1= new Scene(layout, 350, 300);
                    showscore.setScene(scene1);
                    showscore.showAndWait();

                    SetScene(primaryStage, endGameScene, endGameRoot);
                }
            } else if (GameScene.this.getChanged()) {        // if there are some movements happens on cells, then generating random numbers and filling in an empty cell.
                GameScene.this.randomFillNumber();
                setChanged(false);       // set the 'changed' back to false.
            }
        }));
    }
}
