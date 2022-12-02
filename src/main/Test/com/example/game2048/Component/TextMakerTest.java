package com.example.game2048.Component;

import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextMakerTest {
    @Test
    public void changeTwoText() {
        Text first = new Text("first");
        Text second = new Text("second");
        TextMaker change = new TextMaker();
        change.changeTwoText(first,second);
        assertEquals("second",first.getText());
        assertEquals("first",second.getText());
    }

    @Test
    public void madeText(){
        TextMaker make = new TextMaker();
        String input = "2";
        double xCell = 2;
        double yCell = 2;
        Group root = new Group();
        assertEquals("2",make.madeText( input,xCell,yCell, root).getText());
    }
}