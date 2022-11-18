package Game2048;

import java.io.*;

public class RecordUser {
    private static String name = "";
    public String GetHighScoreName() {
        FileReader readFile = null;
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
     * Check whether the highest score is 0 or not,
     * if it is zero, then get the current as a highest score.
     *
     * @return highest score.
     */
    public String getHighscorename() {
        if (name == "") {
            name = this.GetHighScoreName();
        }
        return name;
    }

    public void checkname(String currentname) {
        if (name.equals("")) {
            return;
        }
        if (currentname != name) {
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
        FileWriter writeFile = null;
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

