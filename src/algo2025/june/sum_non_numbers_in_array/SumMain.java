package algo2025.june.sum_non_numbers_in_array;

import static algo2025.may.Util.log;

public class SumMain {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};

        Sum sum = new Sum();
        int result = sum.solution(numbers);
        log.info("result: "+result);
    }
}
