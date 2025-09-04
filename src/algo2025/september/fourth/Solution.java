package algo2025.september.fourth;

/*
    1. 출처: https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java
    2. 문제명: 크기가 작은 부분문자열

    3. 문제해석

    1) 파라미타: 숫자로 구성된 문자열: t, p

    2) 조건: p의 길이로 구성된 t의 여러 부분문자열 중
    이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수 구하기

    3) ex. t="3141592", p="271" 인 경우,
    t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592
    이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159
    2개 입니다.
*/

public class Solution {
    public int solution(String t, String p) {
        int pLength = p.length();
        int tLength = t.length();
        int pInt = Integer.parseInt(p);

        // t와 p의 문자열 길이가 같고,
        // 문자열을 숫자로 변환시 t가 p보다 적거나 같으면 1을 리턴한다.
        if(pLength==tLength) {
            if(Integer.parseInt(t)<=Integer.parseInt(p))
                return 1;
            return 0;
        }

        // t와 p의 문자열의 길이가 다르다.
        // t: 3141592, t.substring(0, 0+3) --> "314"
        int answer = 0;
        int condition = tLength - pLength;
        // t.substring(i, i+pLength).length() == pLength (x)
        // 0 <= 7 - 3
        for(int i=0; i <= condition; i++) {
            // Integer.parseInt(t.substring(i, i+pLength)) <= pInt ?
            String substring = t.substring(i, i + pLength);
            int subInt = Integer.parseInt(substring);
            if(subInt <= pInt) answer++;
        }

        return answer;
    }
}
