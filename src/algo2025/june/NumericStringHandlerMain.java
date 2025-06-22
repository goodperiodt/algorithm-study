package algo2025.june;

public class NumericStringHandlerMain {
    public static void main(String[] args) {
        String ex1 = "123678a";
        String ex2 = "1234";

        NumericStringHandler numericStringHandler = new NumericStringHandler();
        long start = System.currentTimeMillis();
        boolean ex1Result = numericStringHandler.solution(ex1);
        long end = System.currentTimeMillis();
        System.out.println("실행시간: "+(end-start));
        // boolean ex2Result = numericStringHandler.solution(ex2);

        System.out.println(ex1Result);
        // System.out.println(ex2Result);
    }
}
