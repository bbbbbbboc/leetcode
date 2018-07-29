// 122. Best Time to Buy and Sell Stock II

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int max = 0;
        int idx = 0;
        int peak = prices[0];
        int valley = prices[0];
        
        while (idx < prices.length - 1) {
            while (idx < prices.length - 1 && prices[idx] >= prices[idx + 1]) {
                idx++;
            }
            valley = prices[idx];
            while (idx < prices.length - 1 && prices[idx] <= prices[idx + 1]) {
                idx++;
            }
            peak = prices[idx];
            
            max += (peak - valley);
        }
        
        return max;
    }
}


// approach 2
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int max = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                max += (prices[i + 1] - prices[i]);
        }
        
        return max;
    }
}