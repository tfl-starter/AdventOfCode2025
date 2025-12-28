import org.junit.Assert;
import org.junit.Test;

public class DialSpec {
    @Test
    public void example() {
        Dial dial = new Dial();
        Assert.assertEquals(50, dial.location());
        dial.rotate("L68");
        Assert.assertEquals(82, dial.location());
        dial.rotate("L30");
        Assert.assertEquals(52, dial.location());
        dial.rotate("R48");
        Assert.assertEquals(0, dial.location());
        dial.rotate("L5");
        Assert.assertEquals(95, dial.location());
        dial.rotate("R60");
        Assert.assertEquals(55, dial.location());
        dial.rotate("L55");
        Assert.assertEquals(0, dial.location());
        dial.rotate("L1");
        Assert.assertEquals(99, dial.location());
        dial.rotate("L99");
        Assert.assertEquals(0, dial.location());
        dial.rotate("R14");
        Assert.assertEquals(14, dial.location());
        dial.rotate("L82");
        Assert.assertEquals(32, dial.location());

        Assert.assertEquals(6, dial.zero_counter());
    }
    @Test
    public void method_0x434C49434B() {
        Dial dial = new Dial();
        dial.rotate("L68");
        dial.rotate("L30");
        dial.rotate("R48");
        dial.rotate("L5");
        dial.rotate("R60");
        dial.rotate("L55");
        dial.rotate("L1");
        dial.rotate("L99");
        dial.rotate("R14");
        dial.rotate("L82");

        Assert.assertEquals(32, dial.location());
        Assert.assertEquals(6, dial.zero_counter());
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

        // Assert.assertEquals(980, dial.zero_counter());
        Assert.assertEquals(5956, dial.zero_counter());
    }

    public String[] puzzle() {
        Day1Input input = new Day1Input();
        String inputString = input.input();
        String lines[] = inputString.split("\\r?\\n");
        return lines;
    }
}
