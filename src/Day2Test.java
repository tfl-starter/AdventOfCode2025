import org.junit.Assert;
import org.junit.Test;

public class Day2Test {
    @Test
    public void invalidIdsAreParsedCorrectly() {
        Range range = new Range();
        Assert.assertTrue(range.isValid("9"));
        Assert.assertTrue(range.isValid("10"));
        Assert.assertFalse(range.isValid("11"));
        Assert.assertFalse(range.isValid("22"));
    }
    @Test
    public void isValidWhenIdHasNoRepeatingSequence() {
        Range range = new Range();
        Assert.assertTrue(range.isValid("1"));
        Assert.assertTrue(range.isValid("101"));
        Assert.assertTrue(range.isValid("10101"));
    }
    @Test
    public void isInvalidWhenIdHasRepeatingSequence() {
        Range range = new Range();
        Assert.assertFalse(range.isValid("99")); 
        Assert.assertFalse(range.isValid("111")); // repeating "1"
        Assert.assertFalse(range.isValid("1010")); // repeating "10"
        Assert.assertFalse(range.isValid("1111111")); // repeating "1"
        Assert.assertFalse(range.isValid("12341234")); // repeating "1234"
        Assert.assertFalse(range.isValid("123123123")); // repeating "123"
    }
    @Test
    public void stringContains() {
        String left = "1";
        String right = "12";
        Assert.assertFalse(left.contains(right));
    }
}
