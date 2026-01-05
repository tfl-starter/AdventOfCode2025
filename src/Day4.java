import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        System.out.print("AdventOfCode - 2025 - Day 4");

        // Path filePath = FileSystems.getDefault().getPath("src", "day4_example.txt");
        Path filePath = FileSystems.getDefault().getPath("src", "day4.txt");
        System.out.println(filePath.toString());
        System.out.println(filePath.toAbsolutePath().toString());

        int totalSumPaperRolls = 0;

        try {
            String content = Files.readString(filePath, Charset.defaultCharset());
            
            Grid newGrid = new Grid();
            List<List<Character>> grid = newGrid.toGrid(content);
    
            ConsoleLogger logger = new ConsoleLogger(newGrid);

            newGrid.startWatch();
            totalSumPaperRolls = newGrid.pickablePaperRols(grid);
            newGrid.stopWatch();

            System.out.println("Time Elapsed: " + newGrid.elapsedTimeMillis() + " ms"); // Prints: Time Elapsed: 2501            
            System.out.println("Total Sum of Pickable Paper Rolls: " + totalSumPaperRolls);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }
}
