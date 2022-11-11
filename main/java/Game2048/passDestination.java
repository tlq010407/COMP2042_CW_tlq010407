package Game2048;

/**
 * This class is used to contain the method of moving coordinate,
 * when the left, right, up and down key is pressed by user in the keyboard,
 * all cells will be moved to the sides which user pressed,
 * and check whether the cell is empty or not,
 * if the cell is not empty then record the position of the cell.
 */
public class passDestination extends GenerateNumRandom {
    /**
     * Move the cells into the direct which user click,
     * check whether the cell is empty or not,
     * if the cell is not empty then record the position of the cell.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @param direct is the position that user clicked in the keyboard.
     * @return the position which cell is not empty.
     */
    public int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= cellNum - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == cellNum - 1) {
                    coordinate = cellNum - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= cellNum - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == cellNum - 1) {
                    coordinate = cellNum - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }


}
