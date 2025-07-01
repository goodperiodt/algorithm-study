package algo2025.july.word_case_format;

public class WordCaseFormatterMain {
    public static void main(String[] args) {
        String test = "try hello world";
        String result = "TrY HeLlO WoRlD";

        WordCaseFormatter wordCaseFormatter = new WordCaseFormatter();
        String converted = wordCaseFormatter.convert(test);

        System.out.println(converted.equals(result));
    }
}
