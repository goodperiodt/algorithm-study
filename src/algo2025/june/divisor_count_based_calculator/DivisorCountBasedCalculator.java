package algo2025.june.divisor_count_based_calculator;

import java.util.ArrayList;
import java.util.List;

// 약수의 개수가 짝수면 더하고,
// 약수의 개수가 홀수면 빼는 메서드를 갖는 클래스
public class DivisorCountBasedCalculator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    private final List<Integer> numbersWithEvenDivisorCount = new ArrayList<>();
    private final List<Integer> numbersWithOddDivisorCount = new ArrayList<>();

    // @param - left:int, right:int
    // @return - result:int
    //           range -> left ~ right, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수

    // 메서드명 짓기
    // 약수(divisor, factor)
    public int calculateSumByDivisorCount(int left, int right) {
        int start = Math.min(left, right);
        int end = Math.max(left, right);

        validateRange(start, end);

        for(int number = start; number <= end; number++) {
            if(hasEvenNumbersOfDivisors(number))
                numbersWithEvenDivisorCount.add(number);
            else numbersWithOddDivisorCount.add(number);
        }

        return calculateResult();
    }

    // 매개변수 조건: 1 ≤ left ≤ right ≤ 1,000
    private void validateRange(int start, int end) {
        if(start < MIN_VALUE) // start 는 1 미만이어서는 안된다.
            throw new IllegalArgumentException("start 는 1이상 "+end+"보다 작거나 같아야 합니다.");

        if(end > MAX_VALUE) // end 는 1000 초과되어서는 안된다.
            throw new IllegalArgumentException("right 는 "+start+ "이상 1000 이하여야 합니다.");
    }

    // 매개변수로 전달받은 수의 약수 갯수가 짝수인가?
    private boolean hasEvenNumbersOfDivisors(int number) {
        // int divisorCount = calculateDivisorCount(number);
        // return divisorCount%2==0;
        return calculateDivisorCount(number)%2==0;
    }

        private int calculateDivisorCount(int number) {
            int count = 0;
            for(int j = number; j >= 1; j--)
                if (number % j == 0) count++;
            return count;
        }

    // 약수의 개수가 짝수인 List 타입 요소를 모두 더한 값에서
    // 약수의 개수가 홀수인 List 타입 요소를 모두 더한 값을 뺀다.
    private int calculateResult() {
        return sumNumbers(this.numbersWithEvenDivisorCount) - sumNumbers(this.numbersWithOddDivisorCount);
    }

        private int sumNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
}
