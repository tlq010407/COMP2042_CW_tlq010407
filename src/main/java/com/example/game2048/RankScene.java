package com.example.game2048;

import com.example.game2048.Component.Buttons;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class RankScene extends EndGame{
    /**
     * To show the rank scene
     * @param rankRoot the rank root.
     */
    public static void rankScene(Group rankRoot){
        Group root = new Group();
        Text text = new Text("Rank Of Top 10:");
        text.relocate(250, 200);
        text.setFont(Font.font(60));
        rankRoot.getChildren().add(text);
        Button exit = new Button("Exit");
        exit.relocate(250,750);
        exit.setOnMouseClicked(event -> Buttons.quit(root));
        rankRoot.getChildren().add(exit);
        Button backToMenu = new Button("Back to Menu");
        backToMenu.relocate(450,750);
        backToMenu.setOnMouseClicked(new EventHandler<>() {
            @Override
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
        rankRoot.getChildren().add(backToMenu);
        readFile(scoreFile);
        if (users.size() < 10) {
            for (int i = 0; i < users.size(); i++) {
                printRank(rankRoot, i);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                printRank(rankRoot, i);
            }
        }
    }

    /**
     * get the username and user score one by one
     * @param rankRoot the group of rank root
     * @param i the number of the rank list.
     */
    private static void printRank(Group rankRoot, int i) {
        Text rank = new Text((i+1)+"       "+users.get(i));
        rank.setFont(Font.font(40));
        rank.setFill(Color.BLACK);
        rank.relocate(250, (250 + i * 40));
        rankRoot.getChildren().add(rank);
    }
}
