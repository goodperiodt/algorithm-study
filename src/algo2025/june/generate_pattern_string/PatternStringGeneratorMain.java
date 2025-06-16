package algo2025.june.generate_pattern_string;

public class PatternStringGeneratorMain {
    public static void main(String[] args) {
        PatternStringGenerator psg = new PatternStringGenerator();

        String result1 = psg.generatePatternString(15);
        String result2 = psg.generatePatternString(5);

        System.out.println(result1);
        System.out.println(result2);
    }
}
