import org.junit.Assert;
import org.junit.Test;

public class Day2Test {
    @Test
    public void anEmptyRangeIsEmpty() {
        String[] ranges = new Ranges("").toRanges();
        Assert.assertEquals(0, ranges.length);
    }
    @Test
    public void aSingleRangeIsParsedCorrectly() {
        String[] ranges = new Ranges("11-22")
        ConsoleLogger log = new ConsoleLogger(ranges);

        Assert.assertEquals(1, ranges.length);
        Assert.assertEquals("11-22", ranges[0]);
        for (String range : ranges) {
            String[] bounds = range.split("-");
            Assert.assertEquals(2, bounds.length);
            int firstId = Integer.parseInt(bounds[0]);
            int lastId = Integer.parseInt(bounds[1]);
            String invalidIdString = new Range().parseInvalidIds(firstId, lastId);
            Assert.assertEquals("11, 22", invalidIdString);
        }
    }
    @Test
    public void multipleRangesAreParsedCorrectly() {
        String[] ranges = new Ranges("11-22,95-115,998-1012").toRanges();
        Assert.assertEquals(3, ranges.length);
        Assert.assertEquals("11-22", ranges[0]);
        Assert.assertEquals("95-115", ranges[1]);
        Assert.assertEquals("998-1012", ranges[2]);
    }
    @Test
    public void invalidIdsAreParsedCorrectly() {
        Range range = new Range();
        Assert.assertTrue(range.isValid("9"));
        Assert.assertTrue(range.isValid("10"));
        Assert.assertFalse(range.isValid("11"));
        Assert.assertFalse(range.isValid("22"));
    }
    @Test
    public void isValidWhenIdHasNotOddLength() {
        Range range = new Range();
        Assert.assertTrue(range.isValid("1"));
        Assert.assertTrue(range.isValid("101"));
        Assert.assertTrue(range.isValid("10101"));
    }
    @Test
    public void isInvalidWhenIdHasEvenLengthAndBothHalvesAreEqual() {
        Range range = new Range();
        Assert.assertFalse(range.isValid("11"));
        Assert.assertFalse(range.isValid("1010"));
        Assert.assertFalse(range.isValid("123123"));
    }
}
