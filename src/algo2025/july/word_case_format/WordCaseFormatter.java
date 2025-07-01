package algo2025.july.word_case_format;

// WordCaseFormatter - 단어내 대/소문자 변환기
public class WordCaseFormatter {
    public String convert(String s) {
        String[] words = s.trim().split("\\s+");
        String[] convertWords = new String[words.length];

        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            convertWords[i] = transformWord(words[i], sb);
        }

        return String.join(" ", convertWords);
    }

    private String transformWord(String word, StringBuilder sb) {
        transformEvenToUpperCase(word, sb);
        transformOddToLowerCase(word, sb);
        return sb.toString();
    }

    private StringBuilder transformEvenToUpperCase(String word, StringBuilder sb) {
        for(int i = 0; i < word.length(); i+=2) {
            char upperCase = Character.toUpperCase(sb.charAt(i));
            sb.setCharAt(i, upperCase);
        } return sb;
    }

    private StringBuilder transformOddToLowerCase(String word, StringBuilder sb) {
        for(int i = 1; i < word.length(); i+=2) {
            char lowerCase = Character.toLowerCase(sb.charAt(i));
            sb.setCharAt(i, lowerCase);
        } return sb;
    }
}

