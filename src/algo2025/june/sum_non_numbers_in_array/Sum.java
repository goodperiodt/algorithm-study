package algo2025.june.sum_non_numbers_in_array;

import java.util.Arrays;

public class Sum {
    /**
     * @param numbers:int[] -  숫자 0 - 9 중 일부가 들어있음.
     * @return sum:int - numbers 에서 찾을 수 없는 0 - 9 까지의 수를 모두 더한 값
     0 - 9 까지를 모두 더한 값에서 배열에 담긴 요소를 모두 빼면 return 값이 됨.
     */
    public int solution(int[] numbers) {
        // 1 ≤ numbers 의 길이 ≤ 9
        checkValidArrayLength(numbers);

        return sumNotExistNumbersInArray(numbers);
    }



    private void checkValidArrayLength(int[] numbers) {
        int length = numbers.length;
        // 배열의 길이는 0미만, 즉 음수일 수 없나?
        if(length == 0 || length >= 10)
            throw new IllegalArgumentException("배열의 길이는 1이상 9이하여야 합니다. 전달받은 배열의 길이: "+length);
    }

    private int sumNotExistNumbersInArray(int[] numbers) {
        int total = 45;
        int sumNumbersInArray = Arrays.stream(numbers).sum();
        return total - sumNumbersInArray;
    }
}
