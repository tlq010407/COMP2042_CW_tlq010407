package Game2048;

import javafx.scene.Group;
import javafx.scene.text.Text;
import java.util.Random;

/**
 * This class is used to generate random number into empty cell.
 */

public class GenerateNumRandom{
    public static int cellNum = 4;
    public Group root;
    private final TextMaker textMaker = TextMaker.getSingleInstance();
    public Cell[][] cells = new Cell[cellNum][cellNum];

    /**
     *Delete int turn parameter here, since we are not use this.
     */
    public void randomFillNumber() {
        /**
         * Check the empty cells.
         */
        Cell[][] emptyCells = new Cell[cellNum][cellNum];
        int a = 0;
        int b = 0;
        int aForBound = 0, bForBound = 0;
        outer:
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < cellNum - 1) {
                        bForBound = b;
                        b++;
                    } else {
                        aForBound = a;
                        a++;
                        b = 0;
                        if (a == cellNum)
                            break outer;
                    }
                }
            }
        }
    /**
     * Generate the random number between 2 and 4, and fill it into an empty cell.
    */
        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
        int xCell, yCell;
        xCell = random.nextInt(aForBound + 1);
        yCell = random.nextInt(bForBound + 1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

}
