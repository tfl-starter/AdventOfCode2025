import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day3 {
    public static void main(String[] args) {
        System.out.print("AdventOfCode - 2025 - Day 3");

        // Path filePath = FileSystems.getDefault().getPath("src", "day3_example.txt");
        Path filePath = FileSystems.getDefault().getPath("src", "day3.txt");
        System.out.println(filePath.toString());
        System.out.println(filePath.toAbsolutePath().toString());

        Long totalSumJoltage = 0L;

        try {
            String content = Files.readString(filePath, Charset.defaultCharset());
            // System.out.println(content);
            String[] lines = content.split("\\r?\\n");

            
            BatteryBank battery = new BatteryBank();
            ConsoleLogger logger = new ConsoleLogger(battery);

            battery.startWatch();
            battery.detect(lines);
            battery.stopWatch();

            System.out.println("Time Elapsed: " + battery.elapsedTimeMillis() + " ms"); // Prints: Time Elapsed: 2501            
            System.out.println("Total Sum of Joltage: " + battery.totalSumJoltage());

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }
}
