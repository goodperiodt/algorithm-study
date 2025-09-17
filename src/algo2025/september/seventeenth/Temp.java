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
        // 버블정렬 구현하기
        for(int outIndex = 0; outIndex < strings.length - 1; outIndex++) {
            for(int innerIndex = 0; innerIndex < strings.length - 1 - outIndex; innerIndex++) {
                char c1 = strings[innerIndex].charAt(n);
                char c2 = strings[innerIndex + 1].charAt(n);

                // strings[innerIndex].compareTo(strings[innerIndex+1])>0 의 경우,
                // strings[innerIndex] 가 strings[innerIndex+1] 보다 사전순으로 더 나중에 온다는 말
                // 즉 strings[innerIndex+1], strings[innerIndex] 이렇게 배치되게 만들어야 한다는 것.
                if(c1>c2 || (c1 == c2) && strings[innerIndex].compareTo(strings[innerIndex+1]) > 0) {
                    String temp = strings[innerIndex];
                    strings[innerIndex] = strings[innerIndex+1];
                    strings[innerIndex+1] = temp;
                }
            }
        } return strings;
    }
    /* 부분적으로만 정렬이 이루어지는 제한적인 로직
    public String[] solution(String[] strings, int n) {
        // 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
        // ["sun", "bed", "car"]
        String firstString = strings[0]; // String s0 = "sun";
        System.out.println("1. String firstString = strings[0]; firstString: "+firstString);

        for(int index = 1; index < strings.length; index++) {
            // string[1].charAt(1); bed 의 e 가 c1 에 대입
            // c1 = 'e';
            char c1 = strings[index].charAt(n);
            System.out.println("2. char c1 = strings[index].charAt(n); c1: "+c1);


            // char 타입 c 가 c1 보다 크다는 의미,
            // firstString.charAt(1) --> u, u>e
            if(firstString.charAt(n)>c1) {
                String temp = firstString;
                System.out.println("3. String temp = firstString; temp: "+temp);

                strings[index-1] = strings[index]; // strings[0] = strings[1];
                strings[index] = temp;
                System.out.println("4. strings[index] = temp; string[index]: "+strings[index]);
            } firstString = strings[index];
            System.out.println("5. firstString = strings[index]; firstString: "+firstString);

        } return strings;
    } */
}
