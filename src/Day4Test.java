import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class Day4Test {
    @Test
    public void firstTest() {
        Grid newGrid = new Grid();
        String content = "..@@.@@@@.\r\n" + //
                         "@@@.@.@.@@\r\n" + //
                         "@@@@@.@.@@\r\n" + //
                         "@.@@@@..@.\r\n" + //
                         "@@.@@@@.@@\r\n" + //
                         ".@@@@@@@.@\r\n" + //
                         ".@.@.@.@@@\r\n" + //
                         "@.@@@.@@@@\r\n" + //
                         ".@@@@@@@@.\r\n" + //
                         "@.@.@@@.@.\r\n" + //
                         "";
        List<List<Character>> grid = newGrid.toGrid(content);

        Assert.assertEquals(10, grid.size());
        Assert.assertEquals(10, grid.get(0).size());

        Assert.assertFalse(newGrid.paperRoleReadyToPick(0, 0, grid));
        Assert.assertFalse(newGrid.paperRoleReadyToPick(0, 9, grid));
        Assert.assertTrue(newGrid.paperRoleReadyToPick(0, 2, grid));
        Assert.assertTrue(newGrid.paperRoleReadyToPick(1, 0, grid));
        Assert.assertTrue(newGrid.paperRoleReadyToPick(2, 6, grid));

        Assert.assertEquals(13, newGrid.pickablePaperRols(grid));
    }
    @Test
    public void isValid() {
        Grid newGrid = new Grid();
        String content = "@..\r\n" + //
                         "...\r\n" + //
                         "...\r\n" + //
                         "";
        List<List<Character>> grid = newGrid.toGrid(content);
        
        Assert.assertTrue(newGrid.paperRoleReadyToPick(0, 0, grid));
        
        grid = newGrid.toGrid(
        "@@@\r\n" + //
        "@..\r\n" + //
        "...\r\n" + //
        "");
        Assert.assertTrue(newGrid.paperRoleReadyToPick(0, 0, grid));
    }
    @Test
    public void xyTest() {
        Grid newGrid = new Grid();
        List<List<Character>> grid;
        grid = newGrid.toGrid(
        "..@\r\n" + //
        "...\r\n" + //
        "...\r\n" + //
        "");
        Assert.assertTrue(newGrid.isCoordinatePaperRole(0, 2, grid));
        Assert.assertFalse(newGrid.isCoordinatePaperRole(0, 1, grid));
        Assert.assertFalse(newGrid.isCoordinatePaperRole(1, 2, grid));
    }
    @Test
    public void isNotValid() {
        Grid newGrid = new Grid();
        List<List<Character>> grid;
        grid = newGrid.toGrid(
        ".@.\r\n" + //
        "@@@\r\n" + //
        ".@.\r\n" + //
        "");
        Assert.assertFalse(newGrid.paperRoleReadyToPick(1, 1, grid));
        grid = newGrid.toGrid("@.@\r\n" + //
                      ".@.\r\n" + //
                      "@.@\r\n" + //
                      "");
        Assert.assertFalse(newGrid.paperRoleReadyToPick(1, 1, grid));
        grid = newGrid.toGrid("@@.\r\n" + //
                      "@@.\r\n" + //
                      "@@.\r\n" + //
                      "");
        Assert.assertFalse(newGrid.paperRoleReadyToPick(1, 0, grid));
    }
}
