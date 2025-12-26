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

        Assert.assertEquals(3, dial.zero_counter());
    }
}
