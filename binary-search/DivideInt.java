// 29. Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        long ansL = divideL(dividendL, divisorL);
        if (ansL > Integer.MAX_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign * (int) ansL;
        }
    }
    
    private long divideL(long dividendL, long divisorL) {
        if (dividendL < divisorL)
            return 0;

        long sum = divisorL;
        int count = 1;

        while (sum + sum < dividendL) {
            sum += sum;
            count += count;
        }

        return count + divideL(dividendL - sum, divisorL);
    }
}