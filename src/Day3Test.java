import org.junit.Test;
import org.junit.Assert;

public class Day3Test {
    @Test
    public void aNewTest(){
        BatteryBank battery = new BatteryBank();
        // Part 1 - 2 digits
        // Assert.assertEquals(98, battery.maxJoltage("987654321111111"));
        // Assert.assertEquals(89, battery.maxJoltage("811111111111119"));
        // Assert.assertEquals(78, battery.maxJoltage("234234234234278"));
        // Assert.assertEquals(92, battery.maxJoltage("818181911112111"));

        // Part 2 - 12 digits
        Assert.assertEquals(987654321111L, battery.maxJoltage("987654321111111"));
        Assert.assertEquals(811111111119L, battery.maxJoltage("811111111111119"));
        Assert.assertEquals(434234234278L, battery.maxJoltage("234234234234278"));
        Assert.assertEquals(888911112111L, battery.maxJoltage("818181911112111"));
    }
}
