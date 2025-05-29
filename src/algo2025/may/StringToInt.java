package algo2025.may;

import static algo2025.may.Util.log;

/*
    문자열을 인자로 받아 숫자로 반환하는 알고리즘
* */
public class StringToInt {
    public int convertToInt(String input) {
        String data = input.trim();
        checkLength(data);
        checkStartsZero(data);
        String removedPlusSignature = removePlusSignature(data);
        return Integer.parseInt(removedPlusSignature);
    }

    // s의 길이는 1 이상 5이하입니다.
    private boolean isValidLength(String input) {
        int n = input.length();
        return (n >= 1) && (n <= 5);
    }

    private void checkLength(String input) {
        if(!isValidLength(input))
            throw new IllegalArgumentException("input.length()가 1이상 5이하여야 합니다.");
    }

    // s의 맨앞에는 부호(+, -)가 올 수 있습니다.
    // +기호인 경우 제거하고 반환, -기호인 경우 그대로 반환
    private String removePlusSignature(String input) {
        if(input.startsWith("+"))
            return input.substring(1);
        return input;
    }

    // s는 "0"으로 시작하지 않습니다.
    private void checkStartsZero(String input) {
        if (input.startsWith("+") || input.startsWith("-"))
            input = input.substring(1);

        if(input.startsWith("0"))
            throw new IllegalArgumentException("0으로 시작할 수 없습니다.");
    }

    public static void main(String[] args) {
        String input = "+231";

        StringToInt sti = new StringToInt();
        int result = sti.convertToInt(input);
        log.info("result: "+result);
    }
}
