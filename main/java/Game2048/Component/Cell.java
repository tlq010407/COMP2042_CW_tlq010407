package Game2048.Component;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This is a class that contains all the information about the cells.
 */

public class Cell {
    private final Rectangle rectangle;
    private final Group root;
    private Text textClass;
    private boolean modify = false;

    /**
     * Create the cells into the pane.
     * @param x is to initial the coordinates of the cells.
     * @param y is also used to initial the coordinates of the cells.
     * @param scale is the initial length of the size of the cell.
     * @param root is a group for the game root, and used to add the cell into game scene.
     */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * Check whether the number of the cell is changed or not.
     * @return the cells' modify status.
     */
    public boolean getModify() {
        return !modify;
    }
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * Change all parameters of the cell.
     * @param cell is a cell needed to change.
     */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * Add the same number into one cell, and set another cell into 0.
     * @param cell is the cell that need to be added number.
     */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     *Fill different colors with different numbers, whenever new numbers are generated,
     *the color of the cells will be changed to the relation colors depends on the number of the cells contain.
     *
     * @param number is the parameter that cells contain, and different numbers have different colors.
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0 -> rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
            case 2 -> rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
            case 4 -> rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
            case 8 -> rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
            case 16 -> rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
            case 32 -> rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
            case 64 -> rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
            case 128 -> rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
            case 256 -> rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
            case 512 -> rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
            case 1024 -> rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
            case 2048 -> rectangle.setFill(Color.rgb(250, 0, 0, 1));
        }
    }

    /**
     * Get the length of the sides of the cells.
     * @return the number of the length.
     */
    public double getX() {
        return rectangle.getX();
    }

    /**
     * Get the wide of the sides of the cells.
     * @return the number of the wide.
     */
    public double getY() {
        return rectangle.getY();
    }

    /**
     * Get the string number of the cell.
     * @return the number of the cell in integer.
     */
    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }
    private Text getTextClass() {
        return textClass;
    }
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }
}
