package algo2025.may;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

/* 자연수 n이 주어졌을 때,
* n % x == 1이 되는 가장 작은 자연수 x를 반환하기 */
public class Solution5 {
    /**
     * @param n - n의 가능 범위: 3 ≤ n ≤ 1,000,000
     * @return boolean - 전달받은 인자가 3이상 1000000이하인 자연수일 경우, true 반환
     */
    public boolean isValidateNumber(long n) {
        return 3 <= n && n <= 1000000;
    }

    public Set<Long> getSetTypeDivisors(long n) {
        Set<Long> hashSet = new HashSet<>();

        // ver1. 짝수의 경우
        // n 을 divisor 로 나누었을 때 나머지가 1일 때까지 divisor 를 1씩 올린다.
        // 인자 → 나누는 수, 몫, 나머지
        // 12 → 1, 12, 0
        // 12 → 2, 6, 0
        // 12 → 3, 4, 0
        // 12 → 4, 3, 0
        // 12 → 5, 2, 2
        // 12 → 6, 2, 0
        // 12 → 7, 1, 5
        // 12 → 8, 1, 4
        // 12 → 9, 1, 3
        // 12 → 10, 1, 2
        // 12 → 11, 1, 1 → 나머지가 1인 경우의 divisor 가 11, 몫이 1, 나머지가 1 → 이 때의 divisor 를 반환해야함.
        // 12 → 12, 1, 0

        // ver2. 홀수의 경우
        // 인자 → 나누는 수, 몫, 나머지
        // 11 → 1, 11, 0
        // 11 → 2, 5, 1
        // 11 → 3, 3, 2
        // 11 → 4, 2, 3
        // 11 → 5, 2, 1
        // 11 → 6, 1, 5
        // 11 → 7, 1, 4
        // 11 → 8, 1, 3
        // 11 → 9, 1, 2
        // 11 → 10, 1, 1
        // 11 → 11, 1, 0

        // Loop executes zero or billions of times
        for(long i = 1; i <= n; i++) {
            if(n%i==1) hashSet.add(i);
        }
        return hashSet;
    }

    public long getMin(Set<Long> hashSet) throws IllegalArgumentException{
        // Set<Long> - Set<제네릭 타입> 객체만 Set 에 담을 수 있음.
        // Stream<제네릭 타입> - 객체 스트림
        // LongStream - 원시형(long) 값을 담는 숫자형 스트림 객체
        return hashSet.stream()
                // ver1: .mapToLong(divisor -> (long)divisor) // 래퍼 클래스를 원시형으로 변환 Long → long
                // ver2: .mapToLong(Long::longValue)
                // ver3: .mapToLong(divisor -> divisor.longValue())
                .mapToLong(Long::longValue)
                .min() // OptionalLong
                .orElseThrow(()-> new IllegalArgumentException("stream is empty"));
    }

    public long getMinDivisorWithRemainderOne(long n) {
         if(!isValidateNumber(n))
             throw new IllegalArgumentException("유효한 정수가 아닙니다.");
        Set<Long> divisors = getSetTypeDivisors(n);
        return getMin(divisors);
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        Logger log = Logger.getLogger("Solution5");
        Scanner sc = new Scanner(System.in);

        log.info("3이상 1,000,000 이하의 정수를 입력해주세요>>");
        long n = sc.nextLong();

        long result = s.getMinDivisorWithRemainderOne(n);
        log.info("result: "+result);
    }
}
