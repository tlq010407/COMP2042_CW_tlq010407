package com.example.demo;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * This is a class that contains all game scenes.
 */

public class GameScene extends Move{
    private final static int distanceBetweenCells = 10;
    private static final int HEIGHT = 700;
    /**
     * the number of the cell in the game
     */
    public static int cellNum = 4;
    private static double LENGTH = (HEIGHT - ((cellNum + 1) * distanceBetweenCells)) / (double) cellNum;
   // private long score = 0;

    /*Class GameScene(){
        setTitle("2048");
        getContentPane().setBackground(new Color(189, 177, 92));
        setSize((int) LENGTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }*/

    static double getLENGTH() {
        return LENGTH;
    }

    /**
     * Check whether is an empty cell or not.
     * @return 1 if there still get empty cells; 0 if the user already win; -1 if there is no more empty cell.
     */
    private int haveEmptyCell() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if (cells[i][j].getNumber() == 2048)
                    return 0;
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

    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root=root;
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

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

        randomFillNumber();
        randomFillNumber();

        /**
         * Capture the keyboard action and do the corresponding movements in game scene.
         */
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> {
            Platform.runLater(() -> {
                int haveEmptyCell;
                if (key.getCode() == KeyCode.DOWN) {
                    GameScene.this.moveDown();
                } else if (key.getCode() == KeyCode.UP) {
                    GameScene.this.moveUp();
                } else if (key.getCode() == KeyCode.LEFT) {
                    GameScene.this.moveLeft();
                } else if (key.getCode() == KeyCode.RIGHT) {
                    GameScene.this.moveRight();
                }

                scoreText.setText(score + "");
                haveEmptyCell = GameScene.this.haveEmptyCell();
                if (haveEmptyCell == -1) {
                    if (GameScene.this.canNotMove()) {
                        /**
                         * if users cannot move anymore, then switch to the end game scene
                         */
                        primaryStage.setScene(endGameScene);
                        EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                        root.getChildren().clear();
                        score = 0;
                    }
                } else if (haveEmptyCell == 1)
                    GameScene.this.randomFillNumber();
            });
        });
    }
}
