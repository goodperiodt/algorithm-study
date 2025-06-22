package algo2025.june;

public class NumericStringHandlerMain {
    public static void main(String[] args) {
        String ex1 = "123678a";
        String ex2 = "1234";

        NumericStringHandler numericStringHandler = new NumericStringHandler();
        boolean ex1Result = numericStringHandler.solution(ex1);

        System.out.println(ex1Result);
    }
}
