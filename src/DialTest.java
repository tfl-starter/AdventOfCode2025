import java.beans.Transient;
import java.nio.charset.UnsupportedCharsetException;

import org.junit.*;

public class DialTest {
    @Test
    public void newDialReturnLocation50() {
        Dial dial = new Dial();
        Assert.assertEquals(50, dial.location());
    }
    @Test
    public void isLeft() {
        Dial dial = new Dial();
        Assert.assertTrue(dial.isLeft("L5"));
    }
    @Test
    public void newDialRotateLeft() {
        Dial dial = new Dial();
        dial.rotate( "L5");
        Assert.assertEquals(45, dial.location());
    }
    @Test
    public void newDialRotateRight() {
        Dial dial = new Dial();
        dial.rotate( "R10");
        Assert.assertEquals(60, dial.location());
    }
    @Test
    public void newDialRotateRight100() {
        Dial dial = new Dial();
        dial.rotate( "R100");
        Assert.assertEquals(50, dial.location());
    }
    @Test
    public void newDialRotateRight200() {
        Dial dial = new Dial();
        dial.rotate( "R200");
        Assert.assertEquals(50, dial.location());
    }
    @Test
    public void dialLeftOver99() {
        Dial dial = new Dial();
        dial.rotate( "L60");
        Assert.assertEquals(90, dial.location());
    }
    @Test
    public void dialRightBelowZero() {
        Dial dial = new Dial();
        dial.rotate( "R60");
        Assert.assertEquals(10, dial.location());
    }
    @Test
    public void directionLeft() {
        Dial dial = new Dial();
        Assert.assertEquals("L", dial.direction("L5"));
        Assert.assertEquals(1, dial.direction("L5").length());
    }
    @Test
    public void directionRight() {
        Dial dial = new Dial();
        Assert.assertEquals("R", dial.direction("R10"));
    }
    @Test(expected = UnsupportedCharsetException.class)
    public void directionThrowsException() {
        Dial dial = new Dial();
        String direction = dial.direction("X12");
    }
    @Test
    public void distanceLeft() {
        Dial dial = new Dial();
        Assert.assertEquals(5, dial.distance("L5"));
    }
    @Test
    public void distanceRight() {
        Dial dial = new Dial();
        Assert.assertEquals(10, dial.distance("R10"));
    }
    @Test(expected = UnsupportedCharsetException.class)
    public void distanceValueContainCharacters() {
        Dial dial = new Dial();
        int dummyDistance = dial.distance("XYZ");
    }
}
