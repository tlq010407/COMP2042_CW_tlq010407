package Game2048;

import javafx.scene.Group;
import javafx.scene.text.Text;
import java.util.Random;

import static Game2048.MenuController.Mode;

/**
 * This class is used to generate random number into empty cell.
 */
public class GenerateNumRandom{
    public static int cellNum = 4;
    public Group root;
    public Cell[][] cells = new Cell[cellNum][cellNum];

    /**
     *Delete int turn parameter here, since we are not use this.
     */
    public void randomFillNumber() {
        //Check the empty cells.
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
        Random random = new Random();
        Text text;
        boolean choose = random.nextInt() % 2 != 0;
        boolean putTwo = random.nextInt() % 2 != 0;
        int xCell, yCell;
        xCell = random.nextInt(aForBound + 1);
        yCell = random.nextInt(bForBound + 1);
    /*
     * Generate the random number depends on the mode,
     * if user choose the classic mode,
     * then generate numbers between 2 and 4, and fill it into an empty cell;
     * if user choose the survival mode,
     * then generate the numbers among 2, 4, 16 and 32 and fill it into an empty cell;
    */
        if (Mode.equals("Classic") || Mode.equals("Survival")){
            puttwo(emptyCells, putTwo, xCell, yCell);
        }else if (Mode.equals("Hard")){
            if (choose){
                if (putTwo) {
                    text = TextMaker.madeText("16", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
                    emptyCells[xCell][yCell].setTextClass(text);
                    root.getChildren().add(text);
                    emptyCells[xCell][yCell].setColorByNumber(16);
                } else {
                    text = TextMaker.madeText("8", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
                    emptyCells[xCell][yCell].setTextClass(text);
                    root.getChildren().add(text);
                    emptyCells[xCell][yCell].setColorByNumber(8);
                }
            }else{
                puttwo(emptyCells, putTwo, xCell, yCell);
            }
        }
    }

    private void puttwo(Cell[][] emptyCells, boolean putTwo, int xCell, int yCell) {
        Text text;
        if (putTwo) {
            text = TextMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = TextMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }
}
