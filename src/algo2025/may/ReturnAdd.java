package algo2025.may;

import java.util.Scanner;
import java.util.logging.Logger;

// 1. 어떤수의 0승은 무조건 1이라는 사실과
// 2. 규칙을 찾는 과정에서 시간이 많이 소요됨
public class ReturnAdd {
    // 자연수 N의 각 자리수 합을 더해서 반환하기, 자연수 N의 범위: 100,000,000 이하

    public static void main(String[] args) {
        Logger log = Logger.getLogger("ReturnAdd");
        Scanner kb = new Scanner(System.in);
        log.info("자리수를 더할 값을 입력해주세요>>");

        long input = kb.nextLong();
        int length = String.valueOf(input).length();
        log.info("입력한 숫자의 길이: "+length);

        // 4의 자리 4는 10의 몇 승에 해당
        long sum = 0;
        long quotient = 0;

        // input = 123, i = 3
        // input = 23, i = 2
        // input = 3, i = 1, for 문안의 (반복) 로직이 끝난 뒤 i--연산이 이루어지기 때문에,
        // i = 0 이됨, 0은 0보다 크지 않기에 반복문이 종료된다.
        for(int i = length;i>0;i--) {
            /* 어떤 수의 0승은 1이다. */
            int result = (int) Math.pow(10, (i-1)); // result = 100, 10, 1

            quotient=input/result; // quotient = 123/100 → 1, 23/10 → 2
            sum += quotient; // sum = 1, 3, 6
            input -= quotient*result; // input = 23, 3, 0
        }

        log.info("sum: "+sum);
        // 1234%10의 3승(1000)→몫은 1, 나머지는 234 input%10^(length-1) 몫이 나오고,
        // 몫 곱하기 10의 몇 승을 한뒤 원래 입력 값에서 빼면 나머지


        // 234%10의 2승(100)→몫은 2, 나머지는 34
        // 34%10의 1승(10)→몫은 3, 나머지는 4
    }
}
