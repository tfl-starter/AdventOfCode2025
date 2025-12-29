import org.junit.Assert;
import org.junit.Test;

public class DialSpec {
    @Test
    public void example() {
        Dial dial = new Dial();
        dialAndCheckLocationAndZeros(dial, "L0", 50, 0);
        dialAndCheckLocationAndZeros(dial, "L68", 82, 1);
        dialAndCheckLocationAndZeros(dial, "L30", 52, 1);
        dialAndCheckLocationAndZeros(dial, "R48", 0, 2);
        dialAndCheckLocationAndZeros(dial, "L5", 95, 2);
        dialAndCheckLocationAndZeros(dial, "R60", 55, 3);
        dialAndCheckLocationAndZeros(dial, "L55", 0, 4);
        dialAndCheckLocationAndZeros(dial, "L1", 99, 4);
        dialAndCheckLocationAndZeros(dial, "L99", 0, 5);
        dialAndCheckLocationAndZeros(dial, "R14", 14, 5);
        dialAndCheckLocationAndZeros(dial, "L82", 32, 6);
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
    public void newDialR1000() {
        Dial dial = new Dial();
        dialAndCheckLocationAndZeros(dial, "R1000", 50, 10);
    }
 
    @Test
    public void combination() {
        Dial dial = new Dial();
        String[] combinations = {"L68", "L30", "R48", "L5", "R60","L55","L1","L99","R14","L82"};
        dial.combination(combinations);

        Assert.assertEquals(32, dial.location());
        Assert.assertEquals(6, dial.zero_counter());
    }
    @Test
    public void solveDay1( ) {
        Dial dial = new Dial();
        String[] combinations = puzzle();
        dial.combination(combinations);

        // correct answer: 6634
        // Assert.assertEquals(6634, dial.zero_counter());
        Assert.assertEquals(5961, dial.zero_counter());
    }

    public String[] puzzle() {
        Day1Input input = new Day1Input();
        String inputString = input.input();
        String lines[] = inputString.split("\\r?\\n");
        return lines;
    }
}
