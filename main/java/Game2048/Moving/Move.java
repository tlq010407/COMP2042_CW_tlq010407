package Game2048.Moving;

import Game2048.Component.Cell;

/**
 * This class contains the moving methods,
 * while checking whether is available to move vertically and horizontally.
 */
public class Move extends passDestination {
    public int score = 0;
    private boolean changed = false;     //this parameter is used to control and check the movements.
    private boolean merge=false;        // this parameter is used to control double merge.
    public void setChanged(boolean b){
        this.changed = b;
    }
    public boolean getChanged(){
        return changed;
    }

    /**
     * Move all the cells to the left side.
     */
    public void moveLeft() {
        int j;
        for (int i = 0; i < cellNum; i++) {
            for (j = 1; j < cellNum; j++) {
                if (cells[i][j].getNumber() != 0) moveHorizontally(i, j, passLeft(i, j), -1);
            }
        }
        clearcell();  // clear the 'modify' status of all cells.
    }

    /**
     * Move all the cells to the right side.
     */
    public void moveRight() {
        int j;
        for (int i = 0; i < cellNum; i++) {
            for (j = cellNum - 1; j >= 0; j--) {
                if (cells[i][j].getNumber() != 0) moveHorizontally(i, j, passRight(i, j), 1);
            }
        }
        clearcell();   // clear the 'modify' status of all cells.
    }

    /**
     * Move all the cells up.
     */
    public void moveUp() {
        int i;
        for (int j = 0; j < cellNum; j++) {
            for (i = 1; i < cellNum; i++) {
                if (cells[i][j].getNumber() != 0) moveVertically(i, j, passUp(i, j), -1);
            }
        }
        clearcell();   // clear the 'modify' status of all cells.
    }

    /**
     * Move all the cells down.
     */
    public void moveDown() {
        int i;
        for (int j = 0; j < cellNum; j++) {
            for (i = cellNum - 1; i >= 0; i--) {
                if (cells[i][j].getNumber() != 0) moveVertically(i, j, passDown(i, j), 1);
            }
        }
        clearcell(); // clear the 'modify' status of all cells.
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
                    && cells[i][des + sign].getNumber() != 0;}
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
        if (isValidDesH(i, j, des, sign) && cells[i][des].getModify()) {    // add cells[des][j].getModify() to make use once the cell get modified, it cannot merge.
            sumCellNumbersToScore(i,j);         //add the number of the cell to the final score.
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
            changed = true;         // if there is a movement appeared on this cell, then set the 'changed' value to true.
            merge = true;
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
            changed = true;         // if there is a movement appeared on this cell, then set the 'changed' value to true.
            if (merge){         //if this row already merged before, set modify status of cells[j][des] to 'false' to check for double merge.
                cells[i][des].setModify(false);
            }
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
        if (isValidDesV(i, j, des, sign) && cells[des][j].getModify()) {     // add cells[des][j].getModify() to make use once the cell get modified, it cannot merge.
            sumCellNumbersToScore(i,j);     //add the number of the cell to the final score.
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
            changed = true;             // if there is a movement appeared on this cell, then set the 'changed' value to true.
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
            changed = true;             // if there is a movement appeared on this cell, then set the 'changed' value to true.
            if (merge){         //if this column already merged before, set modify status of cells[des][i] to 'false' to check for double merge.
                cells[des][j].setModify(false);
            }
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
    /**
     * This method is used to clear modify and newcell status of every cell once done the moving,
     * to make sure merge only once each time.
     */
    private void clearcell() {
        Cell cell;
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                cell = cells[i][j];
                cell.setModify(false);
            }
        }
    }
}
