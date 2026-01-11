import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        System.out.print("AdventOfCode - 2025 - Day 5");

        // Path rangesFilePath = FileSystems.getDefault().getPath("src", "day5_ranges_example.txt");
        Path rangesFilePath = FileSystems.getDefault().getPath("src", "day5_ranges.txt");
        System.out.println(rangesFilePath.toString());
        System.out.println(rangesFilePath.toAbsolutePath().toString());

        // Path idsFilePath = FileSystems.getDefault().getPath("src", "day5_ids_example.txt");
        Path idsFilePath = FileSystems.getDefault().getPath("src", "day5_ids.txt");
        System.out.println(idsFilePath.toString());
        System.out.println(idsFilePath.toAbsolutePath().toString());

        int totalSumPaperRolls = 0;

        try {
            String rangesContent = Files.readString(rangesFilePath, Charset.defaultCharset());
            String idsContent = Files.readString(idsFilePath, Charset.defaultCharset());
            
            String[] fileRanges = rangesContent.split("\r?\n");
            String[] fileIds = idsContent.split("\r?\n");

            IngredientID id = new IngredientID();
            // make ranges ...
            for (int i = 0; i < fileRanges.length; i++ ){
                id.addRange(fileRanges[i]);
            }

            // count fresh ID's ...
            long countFreshIngredients = 0L;
            for (int i = 0; i < fileIds.length; i++) {
                if (id.isFresh(fileIds[i])) countFreshIngredients++;
            }
            
            // Grid newGrid = new Grid();
            // List<List<Character>> grid = newGrid.toGrid(rangesContent);
    
            // ConsoleLogger logger = new ConsoleLogger(newGrid);

            // newGrid.startWatch();
            // totalSumPaperRolls = newGrid.pickablePaperRols(grid);
            // newGrid.stopWatch();

            // System.out.println("Time Elapsed: " + newGrid.elapsedTimeMillis() + " ms"); // Prints: Time Elapsed: 2501            
            // System.out.println("Total Sum of Pickable Paper Rolls: " + totalSumPaperRolls);
            System.out.println("Total Sum of Fresh IDs: " + countFreshIngredients);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }

}
