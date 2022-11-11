package Game2048;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextMaker {
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
     * Change the number, position of two cells.
     * @param first is the first cell.
     * @param second is the second cell.
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        //Delete the codes here, cuz it is duplicate.
    }

    /**
     * makeText is used to create a new number into the empty cell.
     * @param input is randomly generated number.
     * @param xCell is used to coordinate the position of the empty cell.
     * @param yCell is used to coordinate the position of the empty cell.
     * @param root is used to add the
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
