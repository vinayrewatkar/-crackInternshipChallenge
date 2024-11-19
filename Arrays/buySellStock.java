class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int mini = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int diff = prices[i] - mini;
            profit = Math.max(profit, diff);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}