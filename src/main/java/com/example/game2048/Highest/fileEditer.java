package com.example.game2048.Highest;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to contain the writing file method and overwriting file method.
 * @author liqitang
 */
public class fileEditer{
    /**
     * Check whether the file is exists or not, if not then create a file and write the arraylist into file.
     * @param scoreFile the name of the file.
     * @param users the arraylist contains the scores and users' name.
     */
    public static String writing(File scoreFile, ArrayList<String> users) {
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
                return "Create a File";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writeFile;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
            writer.write(users.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "File Already Exist.";
    }

    /**
     * OverWriting the all datasets into the highscore file.
     * When each tine we read the file, we have to delete and overwrite it.
     * @param scores the arraylist of all scores.
     * @param users the arraylist of all users.
     */
    public static void overwriting(ArrayList<Integer> scores, ArrayList<String> users) {
        scores.sort(Collections.reverseOrder());
        File myObj = new File("highscore.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
        for (int i=0;i< scores.size();i++){
            System.out.println(users.get(i));
        }
        try {
            FileWriter instream = new FileWriter("highscore.txt",false);
            for (Integer score : scores) {
                for (String user : users) {
                    if (Integer.parseInt(user.split(" ")[0]) == score) {
                        instream.write(user + "\n");
                    }
                }
            }
            instream.close();
        } catch(IOException e) {
            System.out.println("The file could not be written to!");
        }
    }
}


