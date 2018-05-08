// 279. Perfect Squares

class Solution {
    public int numSquares(int n) {
        if (n < 1)
            return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            
            while (j * j <= i) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}