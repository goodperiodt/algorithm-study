package algo2025.september.twelfth;
// 출처: https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Temp {

    public int solution(String input) {
        String[] textString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numberString = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int index = 0;
        while(!input.matches("^\\d+$")) { // 입력받은 값이(input) 숫자로만 구성됨(true) 이 아닐 때 --> true
            if(input.contains(textString[index])) {
                input = input.replace(textString[index], numberString[index]);
                // 여기에 index++; 하면 안됨.
            }
            index++;
        }

        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        // String s = "1234";
        String s = "one4seveneight";

        Temp temp = new Temp();
        System.out.println(temp.solution(s));
    }
}
