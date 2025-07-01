package algo2025.july.word_case_format;

// WordCaseFormatter - 단어내 대/소문자 변환기
public class WordCaseFormatter {
    public String convert(String s) {
        String[] words = s.trim().split("\\s+");
        String[] convertWords = new String[words.length];

        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            convertWords[i] = transformWord(sb);
        }

        return String.join(" ", convertWords);
    }

    private String transformWord(StringBuilder sb) {
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, i%2 == 0 ?
                    Character.toUpperCase(c)
                    : Character.toLowerCase(c)
            );
        }
        return sb.toString();
    }
}

