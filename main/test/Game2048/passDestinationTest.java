package Game2048;

import org.junit.Test;

import static org.junit.Assert.*;

public class passDestinationTest {
    @Test
    public void passDestination() {
        var up = new passDestination();
        var down = new passDestination();
        var left = new passDestination();
        var right = new passDestination();
        assertEquals(0, up.passDestination(2,2,'u'));
        assertEquals(0,down.passDestination(2,2,'d'));
        assertEquals(0,left.passDestination(2,2,'l'));
        assertEquals(0,right.passDestination(2,2,'r'));

    }
}