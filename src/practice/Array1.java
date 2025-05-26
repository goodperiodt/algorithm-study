package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("저장할 데이터의 갯수를 입력해주세요: ");
        int n = kb.nextInt();

        int[] data = new int[n];
        System.out.println(data.length+"개의 숫자 데이터를 저장할 공간이 생성되었습니다.");

        // 1. n개의 숫자 데이터를 입력받아 배열에 순서대로 저장한다.
        for(int i = 0; i<data.length; i++) {
            System.out.println((i+1)+"번 째에 저장할 숫자를 입력해주세요: ");
            data[i]=kb.nextInt();
        }
        kb.close();

        // 2. 모든 정수들을 한 칸씩 오른쪽으로 이동시킨다. shift
        // 배열의 마지막 요소의 값을 임시 변수에 저장
        int temp = data[n-1]; // data.length == n

        for(int i=n-1; i>0; i--) {
            data[i] = data[i-1];
        }
        data[0] = temp;

        Arrays.stream(data)
                // .forEach(number-> System.out.println(number));
                .forEach(System.out::println);
    }
}
