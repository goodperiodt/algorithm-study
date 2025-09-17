package algo2025.september.seventeenth;

import jdk.internal.joptsimple.internal.Strings;

/*
* @param strings: String[], n: int
* 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하는 기능
* ex. String[] strings = ["sun", "bed", "car"]이고,
* n = 1, 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings 가 정렬되어
* @return ["car", "bed", "sun"]
*/


public class Temp {
    public String[] solution(String[] strings, int n) {
        return sortByCharAtIndexThenLexical(strings, n);
    }

    private String[] sortByCharAtIndexThenLexical(String[] strings, int n) {
        for(int i = 0; i < strings.length - 1; i++) {
            for(int j = 0; j < strings.length - 1 - i; j++) {
                if(shouldSwap(strings[j], strings[j+1], n))
                    swap(strings, j);
            }
        } return strings;
    }

    private boolean shouldSwap(String a, String b, int n) {
        char c1 = a.charAt(n);
        char c2 = b.charAt(n);

        return (c1 > c2) || ((c1 == c2) && (a.compareTo(b) > 0));
    }

    private void swap(String[] strings, int j) {
        String temp = strings[j];
        strings[j] = strings[j +1];
        strings[j +1] = temp;
    }
}