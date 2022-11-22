package Game2048;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {
    Cell [][] cells = new Cell[4][4];
    Group root = new Group();
    @Test
    public void moveLeft() {
        var left = new Move();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell((j) * 150 + (j + 1) *20,
                        (i) * 150 + (i + 1) * 20, 150, root);
            }
        }
        cells[0][0].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[0][0].getX(),cells[0][0].getY(),root));
        cells[0][1].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[0][1].getX(),cells[0][1].getY(),root));
        cells[0][2].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[0][2].getX(),cells[0][2].getY(),root));
        cells[0][3].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[0][3].getX(),cells[0][3].getY(),root));
        cells[1][0].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[1][0].getX(),cells[1][0].getY(),root));
        cells[1][1].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[1][0].getX(),cells[1][0].getY(),root));
        cells[1][2].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[1][0].getX(),cells[1][0].getY(),root));
        cells[1][3].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[1][0].getX(),cells[1][0].getY(),root));
        cells[2][0].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[2][0].getX(),cells[2][0].getY(),root));
        cells[2][1].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[2][0].getX(),cells[2][0].getY(),root));
        cells[2][2].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[2][0].getX(),cells[2][0].getY(),root));
        cells[2][3].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[2][0].getX(),cells[2][0].getY(),root));
        cells[3][0].setTextClass(TextMaker.getSingleInstance().madeText("2",cells[3][0].getX(),cells[3][0].getY(),root));
        cells[3][1].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[3][0].getX(),cells[3][0].getY(),root));
        cells[3][2].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[3][0].getX(),cells[3][0].getY(),root));
        cells[3][3].setTextClass(TextMaker.getSingleInstance().madeText("0",cells[3][0].getX(),cells[3][0].getY(),root));
        left.moveLeft();
        Assert.assertEquals(2,cells[0][0].getNumber());
        Assert.assertEquals(0,cells[0][1].getNumber());
        Assert.assertEquals(0,cells[0][2].getNumber());
        Assert.assertEquals(0,cells[0][3].getNumber());

        Assert.assertEquals(4,cells[1][0].getNumber());
        Assert.assertEquals(2,cells[1][1].getNumber());
        Assert.assertEquals(0,cells[1][2].getNumber());
        Assert.assertEquals(0,cells[1][3].getNumber());

        Assert.assertEquals(4,cells[2][0].getNumber());
        Assert.assertEquals(0,cells[2][1].getNumber());
        Assert.assertEquals(0,cells[2][2].getNumber());
        Assert.assertEquals(0,cells[2][3].getNumber());

        Assert.assertEquals(2,cells[3][0].getNumber());
        Assert.assertEquals(0,cells[3][1].getNumber());
        Assert.assertEquals(0,cells[3][2].getNumber());
        Assert.assertEquals(0,cells[3][3].getNumber());
    }


    @Test
    public void moveRight() {

    }

    @Test
    public void moveUp() {
    }

    @Test
    public void moveDown() {
    }

    @Test
    public void clearcell() {
    }
}