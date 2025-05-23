package algo2025.may;

import java.util.Arrays;

public class ReturnAvg {
    /**
     *
     * @param arr - int 타입 배열
     * @return double
     * @throws Exception - OptionalDouble.empty() 일 경우, 예외 발생
     */
    public double returnAvgArr(int[] arr) throws Exception {
        // 1. 배열의 합을 담을 변수
        // int sum = 0;

        // 2. int i 초기화 정수 값은 0, 배열 첫 번째 요소 인덱스는 0부터 시작하기 때문

        /* ver1
        for(int i = 0; i < arr.length; i++) {
        // i = 0; 0 < 5;
        // 0 + arr[0] → 1 → sum 은 1;
        // 1 + arr[1] → 2 → sum 은 3;
        // 3 + arr[2] → 3 → sum 은 6;
        // 6 + arr[3] → 4 → sum 은 10;
        // 10 + arr[4] → 5 → sum 은 15;

          // sum=sum+arr[i];
          sum+=arr[i];
        }*/
        /* ver2
        for(int i: arr) {
            sum+=i;
        }

        return (double)sum/arr.length; */

        // Arrays.stream(arr) IntStream 타입
        // Stream.of(arr); Stream<int[]>

        // 1. Arrays.stream() 에 전달되는 배열의 타입에 따라 반환되는 스트림 객체가 달라진다.
        // 배열 요소의 평균을 구하거나 합을 구하는 등의 연산을 진행할 경우
        // 배열을 스트림 객체로 변환해서 IntStream 의 메서드를 활용하면 코드가 깔끔해지는 장점이 있다.
        return Arrays.stream(arr)
                .average()
                .orElseThrow(() -> new Exception("문제가 생겼다."));
    }

    public static void main(String[] args) {
        ReturnAvg ra = new ReturnAvg();
        int[] arr = {1, 2, 3, 4, 5};

        try {
            System.out.println(ra.returnAvgArr(arr));
        } catch (Exception e) {
            System.out.println("e.getMessage(): "+e.getMessage());
        }
        // System.out.println("평균: "+ra.returnAvgArr(arr)); // (double)15/5 → 3.0
    }
}
