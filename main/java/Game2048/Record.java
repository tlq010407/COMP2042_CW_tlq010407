package Game2048;

import java.io.*;
import java.util.Objects;

/**
 * This class is used to record the highest score
 */
public class Record extends RecordUser{
    private static String highscore = "";

    /**
     * Check whether the highest score is 0 or not,
     * if it is zero, then get the current as the highest score.
     * @return highest score.
     */
    public String GetHighScore() {
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader("highscore.txt");
            reader = new BufferedReader(readFile);
            return reader.readLine();
        } catch (Exception e) {
            return "0";
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the highest score.
     * @return highest score.
     */
    public String getHighscore() {
        if (Objects.equals(highscore, "")) {
            highscore = this.GetHighScore();
        }
        return highscore;
    }

    /**
     * Compare the current with the highest score which is stored in the file,
     * if the current score is higher than the highest score,
     * then change the highest score to the current score.
     *
     * @param score current score.
     */
    public void checkscore(int score) {
        if (highscore.equals("")) {
            return;
        }
        if (score > Integer.parseInt(highscore)) {
            highscore = String.valueOf(score);
            getHighscorename();
            checkname(Account.getUserName());
        }
        File scoreFile = new File("highscore.txt");
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter writeFile;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
            writer.write(highscore);
        } catch (Exception e) {
            } finally {
                try {
                    if (writer != null) writer.close();
                } catch (Exception e) {
            }
        }
    }
}
