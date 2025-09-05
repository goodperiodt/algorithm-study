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
public class NumericSubstringCounter {
    // numeric + substring : 숫자와 관련된 부분 문자열, 숫자로 해석될 수 있는 부분 문자열
    public int countLessThanEqualToTarget(String t, String target) {
        int targetLength = target.length();
        int tLength = t.length();
        int condition = tLength - targetLength;

        int targetValue = Integer.parseInt(target);
        int count = 0;

        // t와 p의 문자열 길이가 같고,
        // 문자열을 숫자로 변환시 t가 p보다 적거나 같으면 1을 리턴한다.
        /* if(tLength==targetLength) {
            int tInt = Integer.parseInt(t);
            return tInt <= pInt ? 1:0;
        } */

        // t와 p의 문자열의 길이가 다르다.
        // t: 3141592, t.substring(0, 0+3) --> "314"

        // t.substring(i, i+targetLength).length() == targetLength (x)
        // 0 <= 7 - 3

        // ** for 문 처리시 tLength==targetLength 인 상황도 처리가 된다.
        for(int i=0; i <= condition; i++) {
            String tPart = t.substring(i, i + targetLength);
            int currentValue  = Integer.parseInt(tPart);

            if(currentValue <= targetValue)
                count++;
        }

        return count;
    }
}
