package algo2025.may;

// 파라미터: 자연수 n
// n의 조건: 10,000,000,000이하인 자연수

// n의 각 자리를 원소로 갖는 배열 → 배열을 거꾸로 뒤집어 반환
// ex. n: 12345 → [5,4,3,2,1]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static algo2025.may.Util.kb;
import static algo2025.may.Util.log;

public class ReturnReversingArray {
    private static final long MAX_ALLOWED_NUMBER = 10_000_000_000L;
    private static final long MIN_ALLOWED_NUMBER = 1L;


    public long[] execute(long n) {
        check(n);
        List<Long> digitsList = toDigitsList(n);
        List<Long> reversed = reversedCloneOf(digitsList);
        return reversed.stream()
                .mapToLong(Long::longValue) // LongStream 을 바로 배열로 변환하기 → LongStream.toArray();
                .toArray();
    }

    private List<Long> reversedCloneOf(List<Long> digitsList) {
        // List<Long> copy = new ArrayList<>(digitsList); 얕은 복사
        // Long 타입은 불변 객체이기 때문에 얕은 복사를 해도 문제가 없다.
        List<Long> copy = new ArrayList<>(digitsList);
        Collections.reverse(copy);
        return copy;
    }

    private List<Long> toDigitsList(long n) {
        /* 자연수를 전달받고 → 자연수의 각 자리수를 배열로 바꾼다. long 타입 자연수 → 문자열 → char[] 배열 반환
        // 배열을 reverse 하기 위해 List 타입으로 변환

        char[] charArray = String.valueOf(n).toCharArray();
        List<Long> list = new ArrayList<>();

        // char 타입에서 -'0' 하는 것이 문자형태의 숫자를 실제 숫자로 변환하는 가장 빠른 방법
        for(char c : charArray) list.add((long)(c-'0'));
        return list;
         */
        return String.valueOf(n)
                .chars()
                .map(c -> c - '0')
                .mapToObj(Long::valueOf) // Stream<Long>
                .collect(Collectors.toList()); // → 객체스트림에서만 사용가능
    }

    private boolean isValidNumber(long n) {
        return n >= MIN_ALLOWED_NUMBER && n <= MAX_ALLOWED_NUMBER;
    }

    private void check(long n) {
        if(!isValidNumber(n))
            throw new IllegalArgumentException("10,000,000,000이하인 자연수가 아닙니다.");
    }


    public static void main(String[] args) {
        ReturnReversingArray rra = new ReturnReversingArray();

        log.info("10,000,000,000이하의 자연수를 입력하세요>>");
        long n = kb.nextLong();

        long[] execute = rra.execute(n);
        log.info(Arrays.toString(execute));

        kb.close();
    }
}
