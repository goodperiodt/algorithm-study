package algo2025.june.string_sorter;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StringSorter {
    private int MIN_LENGTH = 1;

    // @param s: String
    // -- s.length >= 1
    // -- 영문 대소문자로만 구성, 대문자는 소문자보다 작은 것으로 간주
    // @return result: String, 전달받은 문자열 파라미터를 큰것부터 작은 순으로 정렬해 반환
    public String sortDescending(String s) {
        validateMinLength(s);
        return getNewString(s);
    }

    private void validateMinLength(String s) {
        // 외부로부터 문자열을 전달받는 것이니 null 을 체크하는 것이 좋다.
        if(s == null || s.isBlank()) // String.isEmpty(): return value.length == 0, s.trim().isEmpty()
            throw new IllegalArgumentException("문자열의 길이는 "+ MIN_LENGTH+"이상이어야 합니다.");
    }

    private String getNewString(String s) {
        return s.chars() // IntStream
                .boxed() // Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 내림차순: 큰 것부터 작은 순으로
                // Integer 객체를 int 타입으로 바꾸고,
                // int 타입을 char 타입으로 바꾸고,
                // char 타입을 String 타입으로 바꾸고,
                .map(i -> String.valueOf((char) i.intValue())) // Stream<String>
                // Stream<String> 타입의 참조변수를 toString 하면 Stream<String> 타입의 객체의 주소를 문자열 타입으로 반환됨.
                .collect(Collectors.joining());
    }
}
