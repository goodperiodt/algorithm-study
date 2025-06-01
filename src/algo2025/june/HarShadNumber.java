package algo2025.june;

import static algo2025.may.Util.log;

public class HarShadNumber {
    // x 범위: x >= 1 && x <= 10000
    private boolean isValid(int n) {
        return (n >= 1) && (n <= 10000);
    }

    private void checkNumber(int n) {
        if(!isValid(n))
            throw new IllegalArgumentException("1 이상, 10000 이하인 정수여야 합니다.");
    }

    private boolean isDivisibleBySumOfDigits(int n) {
        int originalNumber = n;
        // n의 자리수를 합한 값을 구한다.
        /* version1
        int sum = String.valueOf(n)
                .chars() // IntStream
                .map(i -> i - '0') // IntStream
                .sum(); */

        // version2
        int sum = 0;

        while(n>0) {
            sum += n%10; // 자리수를 더한다. n이 112일 경우, 몫: 11, 나머지: 2, sum: 2
            n = n/10; // n: 11

            // 1차 - 몫: 11, 나머지: 2, sum: 2
            // 2차 - 몫: 1, 나머지: 1, sum: 3
            // 3차 - 몫: 0, 나머지: 1, sum: 4 --> 여기서 몫이 0 이되면서 while 문이 종료된다.
        }
        return originalNumber%sum == 0;
    }

    public boolean isHarShadNumber(int n) {
        checkNumber(n);
        return isDivisibleBySumOfDigits(n);
    }

    public static void main(String[] args) {
        HarShadNumber h = new HarShadNumber();
        boolean flag = h.isHarShadNumber(445);
        log.info("flag: "+flag);
    }
}
