import org.junit.Test;
import org.junit.Assert;

public class Day3Test {
    @Test
    public void aNewTest(){
        BatteryBank battery = new BatteryBank();
        Assert.assertEquals(98, battery.maxJoltage("987654321111111"));
        Assert.assertEquals(89, battery.maxJoltage("811111111111119"));
        Assert.assertEquals(78, battery.maxJoltage("234234234234278"));
        Assert.assertEquals(92, battery.maxJoltage("818181911112111"));
    }
}
