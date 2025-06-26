package algo2025.june.gcd_lcm;

import java.util.Arrays;

public class GCDLCMCalculatorMain {
    public static void main(String[] args) {
        GCDLCMCalculator calculator = new GCDLCMCalculator();
        long[] solution = calculator.getGCDAndLCM(3, 12);
        System.out.println(Arrays.toString(solution));

    }
}
