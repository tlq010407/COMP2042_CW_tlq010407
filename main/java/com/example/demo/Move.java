package com.example.demo;

/**
 * This class contains the moving methods,
 * while checking whether is available to move vertically and horizontally.
 */
public class Move extends passDestination{
    public long score = 0;
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
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < cellNum && des + sign >= 0) {
            return cells[i][des + sign].getNumber() == cells[i][j].getNumber() && cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0;
        }
        return false;
    }

    /**
     *
     * @param i
     * @param j
     * @param des
     * @param sign
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

    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < cellNum && des + sign >= 0)
            return cells[des + sign][j].getNumber() == cells[i][j].getNumber() && cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0;
        return false;
    }

    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            sumCellNumbersToScore(i,j);
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

    private void sumCellNumbersToScore(int i, int j) {
                score += cells[i][j].getNumber()*2;
            }


}
