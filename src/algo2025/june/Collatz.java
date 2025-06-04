package algo2025.june;

import static algo2025.may.Util.log;

/* 콜라츠 추측 알고리즘 */
public class Collatz {
    // 1. 입력된 수, num 은 1 이상 8,000,000 미만인 정수
    /* version 1.
    private boolean isValid(long number) {
        return 1 <= number && number <= 8000000;
    }

    private void checkNumberException(long number) {
        if(!isValid(number))
            throw new IllegalArgumentException("1 이상 8,000,000 미만인 정수가 아닙니다.");
    }*/

    private void checkNumberException(long number) {
        if(number < 1 || 8_000_000L < number) // number 가 1일 경우, 1<1 1은 1보다 작은 . 아니니 false 다.
            throw new IllegalArgumentException("1 이상 8,000,000 미만인 정수가 아닙니다.");
    }

    // 짝수라면 2로 나누기 -> 인자가 짝수인지를 판별하는 함수 작성
    // 홀수라면 3 곱하고 1 더하기
    // 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
    public long collatzOperator(long number) {
        if(number==1) return 0;
        return operator(number);
    }

    private long operator(long number) {
        long total = 0;
        while(number != 1) {
           if(total == 500) return -1;
           number = (number%2 == 0)? number/2:(number*3)+1;
           total++;
           log.info("number: "+number);
           log.info("total: "+total);
        }
        return total;
    }

    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        long result = collatz.operator(626331);
        System.out.println("result: "+result);
    }
}
