import org.junit.Assert;
import org.junit.Test;

public class DialSpec {
    @Test
    public void example() {
        Dial dial = new Dial();
        Assert.assertEquals(50, dial.location());
        dial.rotate("L68");
        Assert.assertEquals(82, dial.location());
    }
}
