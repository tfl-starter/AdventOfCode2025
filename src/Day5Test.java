import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class Day5Test {
    private IngredientID cut;

    @BeforeEach
    public void setup() {
        cut = new IngredientID();
        cut.addRange("3-5");
        cut.addRange("10-14");
        cut.addRange("16-20");
    }
    @Test
    public void ingredients_are_fresh() {
        setup();
        String[] ids = {"5", "11", "17"};
        for (int i = 0; i < ids.length; i++) {
            Assert.assertTrue(cut.isFresh(ids[i]));
        }
    }
    @Test
    public void ingredients_are_spoiled() {
        setup();
        String[] ids = {" ", "1", "8", "32"};
        for (int i = 0; i < ids.length; i++) {
            Assert.assertFalse("ID " + ids[i],cut.isFresh(ids[i]));
        }
    }
    @Test
    public void countFreshIngredients() {
        setup();
        String[] ids = {" ", "1", "5", "8", "11", "17", "32"};
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            if (cut.isFresh(ids[i])) count++;
        }
        Assert.assertEquals(3, count);
    }
}
