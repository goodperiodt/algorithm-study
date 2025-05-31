package algo2025.may;

// @param n - 임의의 양의 정수
// 1. n이 어떤 양의 정수 x의 제곱인지 아닌지 판단
// 2. n이 양의 정수 x의 제곱일 경우 → (x+1)의 제곱 반환,
// n이 양의 정수 x의 제곱이 아니라면 -1 반환

// n은 1이상 50000000000000 이하인 양의 정수

import static algo2025.may.Util.log;

public class Solution31 {
    private boolean isValid(long n) {
        return n >= 1 && n <= 50_000_000_000_000L;
    }

    private void checkNumber(long n) {
        if(!isValid(n))
            throw new IllegalArgumentException("1이상 50,000,000,000,000 이하인 양의 정수를 입력해주세요.");
    }

    // 1. n이 어떤 양의 정수 x의 제곱인지 아닌지 판단
    private long isSquareOfPositiveInteger(long n) {
        long x = -1;
        /* for(int i=1; i<=n; i++) {
            if( (n%i==0) && (Math.pow(i, 2) == n) ) x = i;
        } return x; */

        long result = (long)Math.sqrt(n);
        // result*result==n
        if((Math.pow(result, 2))==n) x = result;
        return x;
    }

    private long transformUnlessMinusOne(long n) {
        if(n!=-1) return (long)Math.pow(n+1, 2);
        return n;
    }

    public long execute(long n) {
        checkNumber(n);
        long result = isSquareOfPositiveInteger(n);
        return transformUnlessMinusOne(result);
    }

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        long result = solution.execute(3);
        log.info("result: "+result);
    }
}
