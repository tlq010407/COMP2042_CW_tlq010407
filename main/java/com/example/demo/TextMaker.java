package com.example.demo;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

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
     * Change
     * @param first
     * @param second
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);
    }

    /**
     * makeText is used to create a new number into the empty cell.
     * @param input is randomly generated number.
     * @param xCell is sued to coordinate the position of the empty cell.
     * @param yCell is sued to coordinate the position of the empty cell.
     * @param root
     * @return the cell with filled number and color.
     */
    Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2) * length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

}
