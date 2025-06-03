package algo2025.june;

// @param - 두 정수 a, b
// @return - a와 b 사이에 속한 모든 정수의 합
// ex. a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algo2025.may.Util.log;

// condition
// a와 b가 같은 경우, 둘 중 아무 수나 리턴.
// a와 b는 -10,000,000 이상 10,000,000 이하인 정수
public class SumBetweenNumbers {
    private boolean isInRange(int a) {
        return a >= -10000000 && a <= 10000000;
    }

    private void checkException(int a) {
        if(!isInRange(a))
            throw new IllegalArgumentException("입력하신 "+a+" 는 유효하지 않은 정수입니다.");
    }

    /**
     * 정수 a, b 를 인자로 받아 특정 범위에 속하는지를 체크하는 기능
     * @param a -> checkException(a) -> isInRange(a)
     * @param b -> checkException(b) -> isInRange(b)
     */
    private void checkNumber(int a, int b) {
        checkException(a);
        checkException(b);
    }

    private long sumBetweenNumbers(int a, int b) {
        if(a == b) return a;

        // 만약 a, b가 -1, 3일 경우,
        // i는 -1, b는 3, i가 -1일 때, -1<=3(통과), sum = 0+(-1);, 0
        // i가 0일 때, 0<=3(통과), sum = -1+0; -> sum = -1;
        // i가 1일 때, 1<=3(통과), sum = -1+(1); sum = 0;
        // i가 2일 때, 2<=3(통과), sum = 0+2, sum = 2
        // i가 3일 때, 3<=3(통과), sum = 2+3, sum = 5
        // i가 4일 때, 4<=3(x)

        int min = Math.min(a, b);// (a>b)? b:a;
        int max = Math.max(a, b);// (a>b)? b:a;
        int sum = 0;

        for(int i=min; i<=max; i++) {
            sum += i;
        }
        return sum;
    }

    public long solution(int a, int b) {
        checkNumber(a, b);
        return sumBetweenNumbers(a, b);
    }


    public static void main(String[] args) {
        SumBetweenNumbers sn = new SumBetweenNumbers();
        // -6, -5, -4, -3, -2, -1 -> -21
        // 0, 1, 2 -> 3
        // -21 + 3 -> -18
        long result = sn.solution(-6, 2);
        log.info("result: "+result);
    }
}
