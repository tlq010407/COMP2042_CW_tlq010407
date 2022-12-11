package com.example.game2048.Component;

import com.example.game2048.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is used to contain the all methods about the text changes in cell.
 * @author liqi tang-modified
 */
public class TextMaker {
    private static TextMaker singleInstance = null;
    TextMaker() {
    }

    /**
     * If the cell is empty,
     * then directly add the number to the empty cell.
     * @return the new added cell.
     */
    static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * Change the number, position of two cells.
     * @param first is the first cell.
     * @param second is the second cell.
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        //delete the duplicate code here.
    }

    /**
     * makeText is used to create a new number into the empty cell.
     * @param input is randomly generated number.
     * @param xCell is used to coordinate the position of the empty cell.
     * @param yCell is used to coordinate the position of the empty cell.
     * @param root the group root.
     * @return the cell with filled number and color.
     */
    public static Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.LENGTH;
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2) * length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);
        return text;
    }

}

