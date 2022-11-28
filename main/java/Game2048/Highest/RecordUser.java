package Game2048.Highest;

import Game2048.Highest.Record;

import java.io.*;

/**
 * This class is used to store the recording keeper.
 */
public class RecordUser{
    private static String name = "";

    /**
     * Check whether the name is 'null' or not,
     * if there is no name storing in the file,
     * then create a file and write the current user's name as the recording keeper.
     * @return recording keeper's name.
     */
    public String GetHighScoreName() {
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader("RecordUser.txt");
            reader = new BufferedReader(readFile);
            return reader.readLine();
        } catch (Exception e) {
            return "null";
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
     * Get the name of the recording keeper.
     * @return recording keeper's name.
     */
    public String getHighscoreName() {
        if (name.equals("")) {
            name = this.GetHighScoreName();
        }
        return name;
    }

    /**
     * Check whether the name of the user who get the highest score is same as before or not,
     * if not then change the recording keeper's name and write into file.
     * @param CurrentName current user's name.
     */
    public void checkName(String CurrentName) {
        if (name.equals("")) {
            return;
        }
        if (!CurrentName.equals(name)) {
            name = CurrentName;
        }
        File nameFile = new File("RecordUser.txt");
        Record.writing(nameFile, name);
    }
}

