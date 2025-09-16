package algo2025.september.twelfth;
// 출처: https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Temp {
    // 자바 컨벤션상 static final 변수명은 SNAKE_CASE(단어와 단어 사이를 _로 구분한다) 를 쓰고,
    // 복수형태일 때는 관례적으로 "S"를 붙인다.
    public static final String[] TEXT_STRINGS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static final String[] NUMBER_STRINGS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public int solution(String input) {
        if(isNumeric(input)) {
            return toInt(input);
        }
        return toInt(convert(input));
    }

    // 처음엔 isNumbers 라는 메서드명을 사용했는데,
    // chatgpt 가 문자열이 숫자로만 구성되어 있는지 확인할 땐 isNumeric 이 더 명확하고, 흔하게 쓰인다고 함.
    private boolean isNumeric(String input) {
        return input.matches("\\d+"); //  // --> input.matches("^\\d+$")
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private String convert(String input) {
        for(int index = 0; index < TEXT_STRINGS.length; index++)
            input = input.replace(TEXT_STRINGS[index], NUMBER_STRINGS[index]);
        return input;
    }

    public static void main(String[] args) {
        // String s = "1234";
        String input = "one4seveneight";

        Temp temp = new Temp();
        System.out.println(temp.solution(input));
    }
}
