package algo2025.may;

import java.util.logging.Logger;

public class EvenOdd {
    /*
    * 정수 num 이 짝수일 경우, "Even" 반환, 홀수일 경우, "Odd" 반환하는 함수 정의하기
    * */
    public String solution(int num) {
        return (num%2)==0? "Even":"Odd";
    }

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        String result = evenOdd.solution(3);
        System.out.println(result);
    }

}
