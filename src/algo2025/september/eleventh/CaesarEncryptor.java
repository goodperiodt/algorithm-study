package algo2025.september.eleventh;

import java.util.Arrays;

/*
    시저 암호: 알파벳을 일정 수만큼 밀어서 바꾼다. ex. "AB"는 1만큼 밀면 "BC"가 됨.
    @param - s:String, n: int
    logic - 1. s를 n만큼 밀기 2. 암호문 만들기
 */
// 클래스명: CaesarCipher, CaesarEncryptor, ShiftCipher
public class CaesarEncryptor {
    public String encrypt(String input, int distance) {
        char[] inputCharArray = input.toCharArray(); // String.toCharArray(): char[]
        return encryptChars(distance, inputCharArray);
    }

    // Arrays.toString()은 디버깅용이라 new String() 으로 반환해야 한다고 한다.
    // return Arrays.toString(encryptedArray);
    private String encryptChars(int distance, char[] inputCharArray) {
        char[] encryptedArray = new char[inputCharArray.length];

        for(int index = 0; index< inputCharArray.length; index++)
            encryptedArray[index] = encryptChar(inputCharArray[index], distance);

        return new String(encryptedArray);
    }

    private char encryptChar(char rawChar, int distance) {
        if(Character.isWhitespace(rawChar)) return rawChar;

        if(Character.isUpperCase(rawChar))
            return (char)((rawChar - 'A' + distance) % 26 + 'A');

        if (Character.isLowerCase(rawChar))
            return (char)((rawChar - 'a' + distance) % 26 + 'a');

        throw new IllegalArgumentException("공백, 알파벳 대문자/소문자가 아닌 값을 입력하셨습니다 - "+rawChar);
        // return rawChar;
    }

    public static void main(String[] args) {
        CaesarEncryptor ce = new CaesarEncryptor();
        String encrypted = ce.encrypt("ABCDE", 1);
        System.out.println(encrypted);
    }
}
