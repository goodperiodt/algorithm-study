package algo2025.june.gcd_lcm;

// @param n: int, m: int
// @return result: int[] - 두 수의 최대공약수와 최소공배수를 배열에 담아 반환
// ex. 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

import java.util.*;

// Greatest Common Divisor
// Least Common Multiple
public class GCDLCMCalculator {
    public long[] getGCDAndLCM(int n, int m) {
        return new long[] {
            getGCD(n, m),
            getLCM(n, m)
        };
    }

    private long getGCD(int n, int m) {
        int gcd = 1;

        for(int divisor=1; divisor <= Math.min(n, m); divisor++) {
            if(n%divisor==0 && m%divisor==0)
                gcd = divisor;
        }

        return gcd;
    }

    private long getLCM(int n, int m) {
        long gcd = getGCD(n, m);
        // return gcd * (n / gcd) * (m / gcd);
        // 두 수를 곱하고 최대공약수를 나누면 최소공배수
        return (n/gcd)*m;
    }
}
