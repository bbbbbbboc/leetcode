// 714. Best Time to Buy and Sell Stock with Transaction Fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;
        int buy = -prices[0];
        int sell = 0;
        
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(buy + prices[i] - fee, sell);
            buy = Math.max(sell - prices[i], buy);
        }
        
        return sell;
    }
}