package com.example.game2048.Highest;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is used to write, compare and sort the users with their scores.
 * @author liqitang
 */
public class Record extends fileEditer{
    private static ArrayList<Integer> scores = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> users = new ArrayList<>();
    public static final File scoreFile=new File("highscore.txt");

    /**
     * Read all datasets from the file and store into the arraylists.
     */
    public static void readFile(File scoreFile) {
        scoreFile = new File("highscore.txt");
        if (scores != null){
            scores = new ArrayList<>();
            users = new ArrayList<>();
            names = new ArrayList<>();
        }
        BufferedReader bufReader;
        try {
            FileReader reader = new FileReader(scoreFile);
            bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while (line != null) {
                users.add(line);
                names.add(line.split(" ")[1]);
                scores.add(Integer.parseInt(line.split(" ")[0]));
                line = bufReader.readLine();
            }
            bufReader.close();
        } catch (IOException e) {
            users.add("0 null");
            scores.add(0);
        }
    }
    /**
     * Get the highest score.
     * @return highest score.
     */
    public int getHighscore() {
        return scores.get(0);
    }
    /**
     * Get the highest score username.
     * @return highest score username.
     */
    public String getHighscoreUser(){
        readFile(scoreFile);
        return names.get(0);
    }

    /**
     * Check whether current user is already exists or not,
     * if the user is already exists, then compare the current score with previous score, if current score is higher than the previous one,
     * then change the score;
     * if the user is not exists before, then create a new users in users arraylists, and store the score and username.
     * @param users users arraylist.
     * @param scores scores arraylist.
     * @param names names arraylist.
     * @param score current score
     * @param currentName current username.
     */
    private void compareTo(ArrayList<String> users, ArrayList<Integer> scores, ArrayList<String> names,int score, String currentName){
        if (names.contains(currentName)){
            int index = names.indexOf(currentName);
            if (scores.get(index) <= score){
                users.set(index,score+" "+currentName);
                scores.set(index,score);
            }
        }else{
            users.add(score + " " + currentName);
            scores.add(score);
        }
    }

    /**
     * Compare the scores, users and overwrite into the files.
     * @param score the current score.
     * @param currentUser the current username.
     */
    public void checkscore(int score, String currentUser) {
        compareTo(users,scores,names,score,currentUser);
        File nameFile = new File("highscore.txt");
        writing(nameFile, users);
        overwriting(scores, users);
    }
}


