import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public  class Day2 {
    public static void main(String[] args) throws Exception {
        System.out.println("AdventOfCode - 2025 - Day 2");

        // Path filePath = FileSystems.getDefault().getPath("src", "day2_example.txt");
        Path filePath = FileSystems.getDefault().getPath("src", "day2.txt");
        System.out.println(filePath.toString());
        System.out.println(filePath.toAbsolutePath().toString());

        // BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
        
        Long sumOfInvalidIds = 0L;

        try {
            String content = Files.readString(filePath, Charset.defaultCharset());
            // System.out.println(content);
            String[] lines = content.split("\\r?\\n");
            for (String line : lines) {
                String[] ranges = line.split(",");
                for (String range : ranges) {
                    System.out.println();
                    System.out.print(range + ": ");
                    String[] bounds = range.split("-");
                    long firstId = Long.parseLong(bounds[0]);
                    long lastId = Long.parseLong(bounds[1]);

                    for (long i = firstId; i <= lastId; i++) {
                        String idStr = Long.toString(i);
                        Range rangeObj = new Range();
                        if (!rangeObj.isValid(idStr)) {
                            System.out.print(idStr + ", ");
                            sumOfInvalidIds += i;
                        } 
                    }
                }
            }
            System.out.println();
            System.out.println("Sum of invalid IDs: " + sumOfInvalidIds);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        
    }

}
