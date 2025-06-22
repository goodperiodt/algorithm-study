package algo2025.june;

public class NumericStringHandler {
    public boolean solution(String s) {
        // version1.
        // return (s.length() == 4 || s.length() == 6) && s.matches("\\d+");
        // version2.
        return (s.length() == 4 || s.length() == 6)
                // s.chars() -> 숫자들이 지니는 각 고유의 유니코드 값으로 IntStream 요소가 구성되어 있다.
                // (Character::isDigit); --> (charInt-> Character.isDigit(charInt));
                && s.chars().allMatch(c -> c>='0' && c<='9');
    }
}

/*
    public boolean solution(String s) {
        return isValidLength(s) && isNumeric(s)?
                Boolean.TRUE:
                Boolean.FALSE;
    }

    private boolean isValidLength(String s) {
        return s.length() == 4 || s.length() == 6;
    }

    // 인자가 숫자로 변환될 수 없다면, 예외를 발생 시키는 parsInt(String s);
    private boolean isNumeric(String s) {
        boolean answer = Boolean.FALSE;
        try {
            Integer.parseInt(s);
            answer = Boolean.TRUE;
        } catch (NumberFormatException ignored) {}
        return answer;
    }
*/