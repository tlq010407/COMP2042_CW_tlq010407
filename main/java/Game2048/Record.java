package Game2048;

import java.io.*;

/**
 * This class is used to record the highest score
 */
public class Record{
    private static String highscore="";

    /**
     * Get the highest score.
     * @return highest score.
     */
    public String GetHighScore(){
        FileReader readFile = null;
        BufferedReader reader = null;
        try {
            readFile = new FileReader("highscore.dat");
            reader = new BufferedReader(readFile);
            return reader.readLine();
        }
        catch (Exception e){
            return "0";
        }
        finally {
            try {
                if (reader !=null){
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Check whether the highest score is 0 or not,
     * if it is zero, then get the current as a highest score.
     * @return highest score.
     */
    public String getHighscore(){
        if (highscore==""){
            highscore=this.GetHighScore();
        }
        return highscore;
    }

    /**
     * Compare the current with the highest score which is stored in the file,
     * if the current score is higher than the highest score,
     * then change the highest score to the current score.
     * @param score current score.
     */
    public void checkscore(int score){
        if (highscore.equals("")){
            return;
        }
        if (score>Integer.parseInt(highscore) ){
            highscore = String.valueOf(score);
        }
        File scoreFile = new File("highscore.dat");
        if (!scoreFile.exists()){
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter writeFile = null;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
            writer.write(highscore);
        }catch (Exception e){

        }
        finally {
            try {
                if (writer != null) writer.close();
            }catch (Exception e){}
        }
    }
}
