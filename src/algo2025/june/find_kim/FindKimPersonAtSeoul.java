package algo2025.june.find_kim;

import java.util.Arrays;

/*
* String type 배열 seoul 의 element 중
* "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String 을 반환하는 함수 완성하기
*
    배열의 크기: seoul 은 길이 1 이상, 1000 이하인 배열
    원소의 길이: seoul 의 원소는 길이 1 이상, 20 이하인 문자열
    배열 구성의 최소 조건: "Kim"은 반드시 seoul 안에 포함되어 있어야 함.
* */
public class FindKimPersonAtSeoul {
    String lastName = "Kim";
    String findPerson = "김서방은 ";


    public String findKimPersonAtSeoul(String[] seoul) {
        checkArraySizeException(seoul);
        checkElementsSize(seoul);
        checkKim(seoul);
        // int kimPosition = getKimIndex(seoul);
        return findPerson+getKimIndex(seoul)+"에 있다";
    }

    private int getKimIndex(String[] seoul) {
        int position = -1;
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals(lastName)) position = i;
        } return position;
    }

    /*
    반환 타입이 void 일 때,
    version1.

        for(String person:seoul) {
        String trimPerson = person.trim();
        if(!trimPerson.equals(lastName))
            throw new IllegalArgumentException("Kim 이 존재하지 않습니다.");
    }
    version2.
        Arrays.stream(seoul)
        .forEach(person -> {
            if (!person.equals(lastName))
                throw new IllegalArgumentException(lastName+"이 존재하지 않습니다.");
        });
    */
    private boolean hasKim(String[] seoul) {
        return Arrays.stream(seoul)
                .anyMatch(person->person.equals(lastName));
    }

    private void checkKim(String[] seoul) {
        if(!hasKim(seoul))
            throw new IllegalArgumentException(findPerson+"이 존재하지 않습니다.");
    }

    private void checkElementsSize(String[] seoul) {
        /* version1.
        for(String person: seoul) {
            String trimPerson = person.trim();
            int length = trimPerson.length();
            if(length < 1 || length > 20)
                throw new IllegalArgumentException("문자열의 길이는 1이상 20이하여야 합니다.");
        }*/ // version2.
        Arrays.stream(seoul) // Stream<String>
                .forEach(person -> {
                    if (person == null) throw new NullPointerException("이름이 null 입니다.");
                    // isEmpty() - value.length == 0
                    if (person.isEmpty()) throw new IllegalArgumentException("이름이 빈 문자열입니다.");
                    if (person.length() > 20) throw new IllegalArgumentException("이름의 길이 20을 초과했습니다.");
                });
    }

    private boolean isValidArraySize(String[] seoul) {
        int size = seoul.length;
        return size>=1 && size<=1000;
    }

    private void checkArraySizeException(String[] seoul) {
        if(!isValidArraySize(seoul))
            throw new IllegalArgumentException("배열의 크기는 1이상 1000이하여야 합니다.");
    }
}
