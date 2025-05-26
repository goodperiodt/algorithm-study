package algo2025.may;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class Divisors {
    /**
     * 제한 사항: n은 0 이상 3000이하인 정수입니다.
     * 1. 입력받은 수의 유효성을 검증하는 함수
     * @param input
     * @return boolean - 유효성 통과시 true
     */
    public boolean isValidateNumber(long input) {
        return input>=0 && input<=3000;
        // (input < 0 || input > 3000)? false: true'
        // input>=0 && input<=3000
    }

    /**
     * n의 약수를 모두 담은 리스트를 반환하는 함수
     * 약수는 나누어 떨어지지 않는 수, 1부터 자기자신까지의 수를 나누어본다.
     * @param validatedNumber - n은 0 이상 3000이하인 정수
     * @return Set<Long>
     */
    public Set<Long> getDivisors(long validatedNumber) {
        Set<Long> divisors = new HashSet<>();
        for(long i = 1; i <= validatedNumber; i++) {
            if(validatedNumber%i == 0) divisors.add(i);
        }
        return divisors;
    }

    public long sum(Set<Long> divisors) {
        return divisors.stream() // Stream<Long> stream
                .mapToLong(divisor -> (long) divisor)
                .sum();
    }

    public static void main(String[] args) {
        Logger log = Logger.getLogger("Divisors");
        Divisors ds = new Divisors();
        Scanner kb = new Scanner(System.in);

        log.info("숫자를 입력하세요>>");
        long input = kb.nextLong();

        boolean isValidate = ds.isValidateNumber(input);
        if(!isValidate) throw new IllegalArgumentException("0 이상 3000이하인 정수를 입력해주세요");
        Set<Long> divisors = ds.getDivisors(input);
        long sum = ds.sum(divisors);
        log.info(input+" 약수 합: "+sum);
    }
}
