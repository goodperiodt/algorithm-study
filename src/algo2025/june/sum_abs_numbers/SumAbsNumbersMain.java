package algo2025.june.sum_abs_numbers;

public class SumAbsNumbersMain {
    public static void main(String[] args) {
        SumAbsNumbers sumAbsNumbers = new SumAbsNumbers();

        int[] integers = {4,7,12};
        boolean[] signs = {true,false,true};

        int result = sumAbsNumbers.solution(integers, signs);
        System.out.println("result: "+result);
    }
}
