package Game2048;

/**
 * This class contains the moving methods,
 * while checking whether is available to move vertically and horizontally.
 */
public class Move extends passDestination{
    public int score = 0;

    /**
     * Move all the cells to the left side.
     */
    public void moveLeft() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 1; j < cellNum; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < cellNum; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * Move all the cells to the right side.
     */
    public void moveRight() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = cellNum - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < cellNum; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * Move all the cells up.
     */
    public void moveUp() {
        for (int j = 0; j < cellNum; j++) {
            for (int i = 1; i < cellNum; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < cellNum; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * Move all the cells down.
     */
    public void moveDown() {
        for (int j = 0; j < cellNum; j++) {
            for (int i = cellNum - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < cellNum; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * To check whether user is allowed to move horizontally.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @param des is used to describe the column next to the cells to move.
     * @param sign is used to describe the coordinate to move the cells.
     * @return the boolean result whether user can move or not.
     */
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < cellNum && des + sign >= 0) {
            return cells[i][des + sign].getNumber() == cells[i][j].getNumber() && cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0;
        }
        return false;
    }

    /**
     * Move the cells horizontally till them cannot move anymore, when user press left and right key,
     * and when the number of the cells are same, add them on to the final score,
     * and coalesce the cells with same number.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @param des is used to describe the row next to the cells to move.
     * @param sign is used to describe the coordinate to move the cells.
     */
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            sumCellNumbersToScore(i,j);
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     * To check whether user is allowed to move vertically.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @param des is used to describe the row next to the cells to move.
     * @param sign is used to describe the coordinate to move the cells.
     * @return the boolean result whether user can move or not.
     */
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < cellNum && des + sign >= 0)
            return cells[des + sign][j].getNumber() == cells[i][j].getNumber() && cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0;
        return false;
    }

    /**
     * Move the cells vertically, when user press up and down key,
     * and when the number of the cells are same, add them on to the final score,
     * and coalesce the cells with same number.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @param des is used to describe the row next to the cells to move.
     * @param sign is used to describe the coordinate to move the cells.
     */
    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            sumCellNumbersToScore(i,j);
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
//Move the sum function from the GameScene class to the Move class,
//so that we can sun the final score when we move the cells.

    /**
     * To sum the scores when the cells with number is merged.
     * @param i is the rwo of the cells.
     * @param j is the column of the cells.
     */
    private void sumCellNumbersToScore(int i, int j) {
                score += cells[i][j].getNumber()*2;
            }


}
