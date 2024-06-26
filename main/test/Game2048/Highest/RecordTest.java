package Game2048.Highest;

import org.junit.Test;

import java.io.File;

import static Game2048.Highest.Record.readFile;
import static Game2048.Highest.Record.users;
import static org.junit.Assert.*;

public class RecordTest {
    File scoreFile = new File("test.txt");
    @Test
    public void getHighscore() {
        Record record = new Record();
        readFile(scoreFile);
        int score = record.getHighscore();
        assertEquals(23352,score);
    }

    @Test
    public void getHighscoreUser() {
        Record record = new Record();
        readFile(scoreFile);
        String username = record.getHighscoreUser();
        assertEquals("aaa",username);
    }

    @Test
    public void checkscore(){
        Record check = new Record();
        readFile(scoreFile);
        check.checkscore(20,"gg");
        String score = users.get(users.size()-1).split(" ")[0];
        assertEquals(20, Integer.parseInt(score));
    }

}