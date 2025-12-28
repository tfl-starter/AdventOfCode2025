public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("AdventOfCode - 2025");
        // day1_examples();
        day1_solution();
    }

    private static void day1_solution() {
        final Dial dial = new Dial();
        final ConsoleLogger log = new ConsoleLogger(dial);

        Day1Input input = new Day1Input();
        String inputString = input.input();
        String[] combinations = inputString.split("\\r?\\n");
        dial.combination(combinations);
        System.out.println("Day 1 solution --------------");
        dial.zero_counter();
        System.out.println("Day 1 solution --------------");
    }

    private static void day1_examples() {
        final Dial dial = new Dial();
        final ConsoleLogger log = new ConsoleLogger(dial);

        String[] combinations = {"L68", "L30", "R48", "L5", "R60","L55","L1","L99","R14","L82"};
        dial.combination(combinations);
        System.out.println("Day 1 examples --------------");
        dial.zero_counter();
        System.out.println("Day 1 examples --------------");

        final Dial dial2 = new Dial();
        final ConsoleLogger log2 = new ConsoleLogger(dial2);
        dial2.rotate("R1000");
        System.out.println("Day 1 extra example --------------");
        dial2.zero_counter();
        System.out.println("Day 1 extra example --------------");
    }
}
