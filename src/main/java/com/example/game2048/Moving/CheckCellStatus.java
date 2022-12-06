package com.example.game2048.Moving;

/**
 * This class is used to check cells.
 * @author liqi tang
 */

public class CheckCellStatus extends Move {
    /**
     * Check whether is an empty cell or not.
     * @return 1 if there still get empty cells; 0 if the user already win; -1 if there is no more empty cell.
     */
    public int haveEmptyCell() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (cells[i][j].getNumber() == 2048) {
                    return 0;
                }else if (cells[i][j].getNumber() == 0) {
                    return 1;
                }
            }
        }
        return -1;
    }
    /**
     * Check if there have same numbers nearly that user can continue the game.
     * @param i is position in the row.
     * @param j is the position in the colum.
     * @return boolean as a result.
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < cellNum - 1 && j < cellNum - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }
    /**
     * Check whether user can still move ot mot.
     * @return the boolean as a result.
     */
    public boolean canNotMove() {
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}