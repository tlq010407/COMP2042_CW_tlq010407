package com.example.game2048.Highest;

import org.junit.Test;
import java.io.File;
import static com.example.game2048.Highest.Record.readFile;
import static com.example.game2048.Highest.Record.users;
import static org.junit.Assert.*;

/**
 * This class is used to test the record class functions.
 * @author liqi tang
 */
public class RecordTest {
    File scoreFile = new File("test.txt");
    @Test
    public void getHighscore() {
        Record record = new Record();
        readFile(scoreFile);
        int score = record.getHighscore();
        assertEquals(99999,score);
    }

    @Test
    public void getHighscoreUser() {
        Record record = new Record();
        readFile(scoreFile);
        String username = record.getHighscoreUser();
        assertEquals("tlq",username);
    }

    @Test
    public void checkscore(){
        Record check = new Record();
        readFile(scoreFile);
        check.checkscore(20,"gg");
        String score = users.get(users.size()-1).split(" ")[0];
        assertEquals(20, Integer.parseInt(score));
    }
    @Test
    public void testWriting(){
        Record writing = new Record();
        File test = new File("tests.txt");
        assertEquals("Create a File",  writing.writing(test,users));
        File test2 = new File("highscore.txt");
        assertEquals( "File Already Exist.",writing.writing(test2,users));
    }
}