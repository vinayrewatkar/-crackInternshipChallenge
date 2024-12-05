class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize the dp array with a large value
        int[] dp = new int[amount + 1];
        // Base case: to make amount 0, 0 coins are needed
        dp[0] = 0;

        // Fill the dp array
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large value
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] is still Integer.MAX_VALUE, it means no solution exists
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
