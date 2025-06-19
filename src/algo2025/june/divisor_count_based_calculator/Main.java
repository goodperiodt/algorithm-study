package algo2025.june.divisor_count_based_calculator;

import static algo2025.may.Util.log;

public class Main {
    public static void main(String[] args) {

        int left = 24;
        int right = 27;

        DivisorCountBasedCalculator divisorCalc = new DivisorCountBasedCalculator();
        int result = divisorCalc.calculateSumByDivisorCount(left, right);
        log.info(left+", "+right+": "+result);

    }
}
