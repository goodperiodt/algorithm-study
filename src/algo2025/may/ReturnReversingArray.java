package algo2025.may;

// 파라미터: 자연수 n
// n의 조건: 10,000,000,000이하인 자연수

// n의 각 자리를 원소로 갖는 배열 → 배열을 거꾸로 뒤집어 반환
// ex. n: 12345 → [5,4,3,2,1]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static algo2025.may.Util.kb;
import static algo2025.may.Util.log;

public class ReturnReversingArray {
    public long[] execute(long n) {
        // 유효성 검증
        if(!isValidateNumber(n))
            throw new IllegalArgumentException("10,000,000,000이하인 자연수가 아닙니다.");

        List<Long> digitsList = toDigitsList(n);
        // Collections.reverse(List list); 원본을 바꿈.

        List<Long> reversed = reversedCloneOf(digitsList);

        return reversed.stream()
                .mapToLong(Long::longValue)
                .toArray();
    }

    private List<Long> reversedCloneOf(List<Long> digitsList) {
        // 얕은 복사
        List<Long> copy = new ArrayList<>(digitsList);
        Collections.reverse(copy);
        return copy;
    }

    private List<Long> toDigitsList(long n) {
        // 자연수를 전달받고 → 자연수의 각 자리수를 배열로 바꾼다. long 타입 자연수 → 문자열 → char[] 배열 반환
        // 배열을 reverse 하기 위해 List 타입으로 변환
        //
        char[] charArray = String.valueOf(n).toCharArray();

        List<Long> list = new ArrayList<>();

        // char 타입에서 -'0' 하는 것이 문자형태의 숫자를 실제 숫자로 변환하는 가장 빠른 방법
        for(char c : charArray) list.add((long)(c-'0'));
        return list;
    }

    private boolean isValidateNumber(long n) {
        return n > 0 && n <= 10000000000L;
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
