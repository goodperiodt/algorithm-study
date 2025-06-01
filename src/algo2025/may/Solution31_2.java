package algo2025.may;
import java.util.Comparator;
import java.util.stream.Collectors;

import static algo2025.may.Util.log;
public class Solution31_2 {
    // 정수 n 을 매개변수로 입력받는다 → n 은 1 이상 8000000000 이하인 자연수다.
    private boolean isValid(long n) {
        return n >= 1 && n <= 8_000_000_000L;
    }

    private void check(long n) {
        if(!isValid(n)) {
            log.info("1 이상 8000000000 이하인 자연수가 아닙니다.");
            throw new IllegalArgumentException("1 이상 8000000000 이하인 자연수가 아닙니다.");
        }
    }

    // n 의 각 자리수를 큰 것부터 작은 수까지 새로 정렬한 새로운 정수를 반환한다.
    private long transform(long n) {
        // n의 자리 수가 10의 자리 이상이면, 문자열의 길이 2 이상이면
        String numberToString = String.valueOf(n);
        if(!(numberToString.length() >= 2)) return n;

        // char 타입 데이터들이 연속적으로 나열되어 있는 배열: char[]
        // String 타입 데이터.chars() 메서드 호출시 IntStream 타입 반환
        String newStringTypeInt = numberToString.chars()// IntStream
                .map(i -> i - '0')// IntStream
                // .mapToObj(i->String.valueOf(i))
                .boxed() // Stream<Integer>
                // 객체 스트림에서 Comparator 사용 가능
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf) // Stream<String>
                // .collect(Collectors.joining()) 은 Stream<String> 의 타입일 경우에만 사용이 가능하다.
                .collect(Collectors.joining());
        // .mapToObj(Long::valueOf) // Stream<Long>
                // .sorted(Comparator.reverseOrder());// Stream<Long>
        // Long.valueOf() 와 Long.parseLong() 의 차이?
        return Long.parseLong(newStringTypeInt);
    }

    public long execute(long n) {
        check(n);
        return transform(n);
    }

    public static void main(String[] args) {
        Solution31_2 s = new Solution31_2();
        long result = s.execute(137402);// 743210
        log.info("result: "+result);
    }
}
