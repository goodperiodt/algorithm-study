package algo2025.june.sum_abs_numbers;

import java.lang.reflect.Array;

public class SumAbsNumbers {
    /**
     *
     * @param absolutes: boolean[] - signs 배열에 담긴 절대값 정수들의 부호를 차례대로 담은 불리언 배열
     * @param signs: int[] - 절대값이 담긴 정수 배열
     * @return sumNumbers(numbersWithSign): int - 실제 정수들의 합
     */
    public int solution(int[] absolutes, boolean[] signs) {
        checkArrayTypeAndLength(absolutes, signs);
        checkArrayElements(absolutes);
        int[] numbersWithSign = getNumbersWithSign(absolutes, signs);
        return sumNumbers(numbersWithSign);
    }

    // absolutes - 길이: 1 이상 1,000 이하
    // signs - 길이: absolutes 의 길이와 동일, 1 이상 1,000 이하
    private void checkArrayTypeAndLength(Object...arrays) {
        checkArrayType(arrays);
        checkArrayLength(arrays);
    }

    private void checkArrayType(Object...arrays) {
        for(Object array : arrays) {
            if(!array.getClass().isArray())
                throw new IllegalArgumentException(array+"는 배열이 아닙니다.");
        }
    }

    private void checkArrayLength(Object...arrays) {
        for(Object array: arrays) {
            if(!isValidArrayLength(array))
                throw new IllegalArgumentException("배열의 길이는 1이상 1,000 이하여야 합니다.");
        }
    }

    private boolean isValidArrayLength(Object array) {
        int length = Array.getLength(array);
        return length >= 1 && length <= 1000;
    }

    // absolutes - 요소: 각각 1 이상 1,000 이하
    private void checkArrayElements(int[] absolutes) {
        for(int absolute: absolutes) {
            if(!isValidAbsolute(absolute))
                throw new IllegalArgumentException("요소의 값은 1이상 1000이하여야 합니다.");
        }
    }

    private boolean isValidAbsolute(int absolute) {
        return absolute >= 1 && absolute <= 1000;
    }

    private int[] getNumbersWithSign(int[] absolutes, boolean[] signs) {
        char[] chars = convertBooleanToSigns(signs);
        return getIntegersWithSign(absolutes, chars);
    }
 
    private char[] convertBooleanToSigns(boolean[] signs) {
        char[] newSigns = new char[signs.length];
        for(int i=0; i<newSigns.length; i++)
            newSigns[i] = signs[i]? '+' : '-';
        return newSigns;
    }

    private int[] getIntegersWithSign(int[] absolutes, char[] chars) {
        int[] integersWithSign = new int[absolutes.length];
        for(int i=0; i<absolutes.length; i++) {
            integersWithSign[i] = (chars[i] == '-')? -absolutes[i]: absolutes[i];
        }
        return integersWithSign;
    }

    private int sumNumbers(int[] numbersWithSign) {
        // return Arrays.stream(numbersWithSign).sum();
        int sum = 0;
        for(int number : numbersWithSign) sum += number;
        return sum;
    }
}
