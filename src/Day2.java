import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.lang3.time.StopWatch;

public  class Day2 {
    public static void main(String[] args) throws Exception {
        System.out.println("AdventOfCode - 2025 - Day 2");

        // Path filePath = FileSystems.getDefault().getPath("src", "day2_example.txt");
        Path filePath = FileSystems.getDefault().getPath("src", "day2.txt");
        System.out.println(filePath.toString());
        System.out.println(filePath.toAbsolutePath().toString());

        // BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
        
        Long sumOfInvalidIds = 0L;

        // new Range().isValid4("33");
        // System.out.println(new Range().isValid4("33"));
        // System.out.println(new Range().isValid4("998"));
        // System.out.println(new Range().isValid4("999"));
        // System.out.println(new Range().isValid4("5566"));
        // System.out.println(new Range().isValid4("1010"));
        // System.out.println(new Range().isValid4("121212"));
        // System.out.println(new Range().isValid4("123123"));
        // System.out.println(new Range().isValid4("17311731"));
        // System.out.println(new Range().isValid4("14214299"));
        // System.exit(0);

        try {
            String content = Files.readString(filePath, Charset.defaultCharset());
            // System.out.println(content);
            String[] lines = content.split("\\r?\\n");

            Duplicate doublicates = new Duplicate();
            ConsoleLogger logger = new ConsoleLogger(doublicates);

            doublicates.startWatch();
            doublicates.detect(lines);
            doublicates.stopWatch();

            System.out.println("Time Elapsed: " + doublicates.elapsedTimeMillis() + " ms"); // Prints: Time Elapsed: 2501            
            System.out.println("Sum of invalid IDs: " + doublicates.subOfInvalidIds());

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        
    }

}
