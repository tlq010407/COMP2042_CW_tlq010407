package Game2048;

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
    public String getHighscorename() {
        if (name.equals("")) {
            name = this.GetHighScoreName();
        }
        return name;
    }

    /**
     * Check whether the name of the user who get the highest score is same as before or not,
     * if not then change the recording keeper's name and write into file.
     * @param currentname current user's name.
     */
    public void checkname(String currentname) {
        if (name.equals("")) {
            return;
        }
        if (!currentname.equals(name)) {
            name = currentname;
        }
        File nameFile = new File("RecordUser.txt");
        if (!nameFile.exists()) {
            try {
                nameFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter writeFile;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(nameFile);
            writer = new BufferedWriter(writeFile);
            writer.write(name);
        } catch (Exception e) {

        } finally {
            try {
                if (writer != null) writer.close();
            } catch (Exception e) {
            }
        }
    }
}

