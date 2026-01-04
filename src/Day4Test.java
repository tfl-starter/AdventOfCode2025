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
        List<List<Character>> grid = toGrid(content);

        Assert.assertEquals(10, grid.size());
        Assert.assertEquals(10, grid.get(0).size());

        Assert.assertFalse(paperRoleReadyToPick(0, 0, grid));
        Assert.assertFalse(paperRoleReadyToPick(0, 9, grid));
        Assert.assertTrue(paperRoleReadyToPick(0, 2, grid));
        Assert.assertTrue(paperRoleReadyToPick(1, 0, grid));
        Assert.assertTrue(paperRoleReadyToPick(2, 6, grid));
    }
    @Test
    public void isValid() {
        String content = "@..\r\n" + //
                         "...\r\n" + //
                         "...\r\n" + //
                         "";
        List<List<Character>> grid = toGrid(content);
        
        Assert.assertTrue(paperRoleReadyToPick(0, 0, grid));
        
        grid = toGrid(
        "@@@\r\n" + //
        "@..\r\n" + //
        "...\r\n" + //
        "");
        Assert.assertTrue(paperRoleReadyToPick(0, 0, grid));
    }
    @Test
    public void xyTest() {
        List<List<Character>> grid;
        grid = toGrid("..@\r\n" + //
                      "...\r\n" + //
                      "...\r\n" + //
                      "");
        Assert.assertTrue(isCoordinatePaperRole(0, 2, grid));
        Assert.assertFalse(isCoordinatePaperRole(0, 1, grid));
        Assert.assertFalse(isCoordinatePaperRole(1, 2, grid));
    }
    @Test
    public void isNotValid() {
        List<List<Character>> grid;
        grid = toGrid(".@.\r\n" + //
                      "@@@\r\n" + //
                      ".@.\r\n" + //
                      "");
        Assert.assertFalse(paperRoleReadyToPick(1, 1, grid));
        grid = toGrid("@.@\r\n" + //
                      ".@.\r\n" + //
                      "@.@\r\n" + //
                      "");
        Assert.assertFalse(paperRoleReadyToPick(1, 1, grid));
        grid = toGrid("@@.\r\n" + //
                      "@@.\r\n" + //
                      "@@.\r\n" + //
                      "");
        Assert.assertFalse(paperRoleReadyToPick(1, 0, grid));
    }

    private boolean paperRoleReadyToPick(int y, int x, List<List<Character>> grid) {
        if (!isCoordinatePaperRole(y, x, grid)) return false;

        int count = 0;

        if (isNorth(y, x, grid)) count++;
        if (isSouth(y, x, grid)) count++;
        if (isEast(y, x, grid)) count++;
        if (isWest(y, x, grid)) count++;
        if (isNorthEast(y, x, grid)) count++;
        if (isNorthWest(y, x, grid)) count++;
        if (isSouthEast(y, x, grid)) count++;
        if (isSouthWest(y, x, grid)) count++;
     
        if (count < 4) return true;

        return false;
    }

    private boolean isNorth(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y-1, x, grid);
    }
    private boolean isSouth(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x, grid);
    }
    private boolean isEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y, x+1, grid);
    }
    private boolean isWest(int y, int x, List<List<Character>> grid) {
         return isCoordinatePaperRole(y, x-1, grid);
    }
    private boolean isNorthEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y-1, x+1, grid);
    }
    private boolean isNorthWest(int y, int x, List<List<Character>> grid) {
       return isCoordinatePaperRole(y-1, x-1, grid);
    }
    private boolean isSouthEast(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x+1, grid);
    }
    private boolean isSouthWest(int y, int x, List<List<Character>> grid) {
        return isCoordinatePaperRole(y+1, x-1, grid);
    }

    public boolean isCoordinatePaperRole(int y, int x, List<List<Character>> grid) {
        if (y < 0 || y > grid.size()) return false;
        if (x < 0 || x > grid.get(y).size()) return false;

        char coordinate = grid.get(y).get(x);
        if (coordinate != '@') return false;
        return true;
    }

    private List<List<Character>> toGrid(String content) {
        String[] lines = content.split("\r?\n");

        // make grid ...
        List<List<Character>> grid = new ArrayList<List<Character>>();

        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            List<Character> yLine = new ArrayList<Character>();
            for (int x = 0; x < line.length(); x++ ) {
                yLine.add(line.charAt(x));
            }
            grid.add(yLine);
        }
        return grid;
    }
}
