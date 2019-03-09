// 309. Best Time to Buy and Sell Stock with Cooldown

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int buy = Integer.MIN_VALUE;
        int preBuy = 0;
        int sell = 0;
        int preSell = 0;
        
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        
        return sell;
    }
}