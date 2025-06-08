package algo2025.june;

import java.util.Arrays;

import static algo2025.may.Util.log;

public class DivisibleNumberFinderMain {
    public static void main(String[] args) {
        DivisibleNumberFinder finder = new DivisibleNumberFinder();

        int[] array = {2, 3, 4, 5, 7, 9, 11};
        int divisor = 11;

        int[] result = finder.solution(array, divisor);
        log.info(Arrays.toString(result));
    }
}
