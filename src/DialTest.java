import java.nio.charset.UnsupportedCharsetException;

import org.junit.*;

public class DialTest {
    @Test
    public void aNewDialHasLocation50() {
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
        ConsoleLogger log = new ConsoleLogger(dial);
        dial.rotate( "L5");
        Assert.assertEquals(45, dial.location());
    }
    @Test
    public void newDialRotateRight() {
        Dial dial = new Dial();
        dial.rotate( "R10");
        Assert.assertEquals(60, dial.location());
        Assert.assertEquals(0, dial.zero_counter());
    }
    @Test
    public void newDialRotateRight100() {
        Dial dial = new Dial();
        dial.rotate( "R100");
        Assert.assertEquals(50, dial.location());
        Assert.assertEquals(1, dial.zero_counter());
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
        Assert.assertEquals(5, dial.newLocation("L5"));
    }
    @Test
    public void distanceRight() {
        Dial dial = new Dial();
        Assert.assertEquals(10, dial.newLocation("R10"));
    }
    @Test(expected = UnsupportedCharsetException.class)
    public void distanceValueContainCharacters() {
        Dial dial = new Dial();
        int dummyDistance = dial.newLocation("XYZ");
    }
    @Test
    public void newDialLeftRight() {
        Dial dial = new Dial();

        dialAndCheckLocationAndZeros(dial, "R50", 0, 1);
        dialAndCheckLocationAndZeros(dial, "L50", 50, 1);
        
        dialAndCheckLocationAndZeros(dial, "L50", 0, 2);
        dialAndCheckLocationAndZeros(dial, "L50", 50, 2);

    }   

    private void dialAndCheckLocationAndZeros(Dial dial, String rotation, int expectedLocation, int expectedZeros) {
        dial.rotate(rotation);
        checkLocationAndZeros(dial, expectedLocation, expectedZeros);
    }

    private void checkLocationAndZeros(Dial dial, int expectedLocation, int expectedZeros) {
        Assert.assertEquals(expectedLocation, dial.location());
        Assert.assertEquals(expectedZeros, dial.zero_counter());
    }
    @Test
    public void rotateAndCheck() {
        rotateAndCheckZeros("R50", 1);
        rotateAndCheckZeros("L50", 1);
    }
    private void rotateAndCheckZeros(String rotation, int expectedZeros) {
        Dial dial = new Dial();
        dial.rotate(rotation);
        Assert.assertEquals(expectedZeros, dial.zero_counter());
    }

}
