package algo2025.july.word_case_format;

// WordCaseFormatter - 단어내 대/소문자 변환기
public class WordCaseFormatter {
    private static final String REGEX = "\\s+";
    private static final String DELIMETER = " ";
    
    public String convert(String s) {
        String[] words = s.trim().split(REGEX);
        String[] convertWords = new String[words.length];

        for(int i = 0; i < words.length; i++) {
            convertWords[i] = transformWord(words[i]);
        }

        return String.join(DELIMETER, convertWords);
    }

    private String transformWord(String word) {
        StringBuilder sb = new StringBuilder(word);

        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, isEvenIndex(i) ?
                Character.toUpperCase(c):
                Character.toLowerCase(c)
            );
        }

        return sb.toString();
    }

    private boolean isEvenIndex(int i) {
        return i % 2 == 0;
    }
}

