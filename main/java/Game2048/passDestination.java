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
     * When user press left key, check whether the cells are empty or not, when cells moving left.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @return the position which cell is not empty.
     */
    public int passLeft(int i, int j){
        int coordinate = j;
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

    /**
     * When user press right key, check whether the cells are empty or not, when cells moving right.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @return the position which cell is not empty.
     */
    public int passRight(int i, int j){
        int  coordinate = j;
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
    /**
     * When user press down key, check whether the cells are empty or not, when cells moving down.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @return the position which cell is not empty.
     */
    public int passDown(int i, int j){
        int  coordinate = i;
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
    /**
     * When user press up key, check whether the cells are empty or not, when cells moving up.
     * @param i is used to describe the row of the cell in.
     * @param j is used to describe the column of the cell in.
     * @return the position which cell is not empty.
     */
    public int passUp(int i, int j){
        int coordinate = i;
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
}
