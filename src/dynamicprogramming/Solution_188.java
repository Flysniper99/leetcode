package dynamicprogramming;

/**
 * 买卖股票的最佳时机IV
 * dp[i][j][0]表示第i天第j次持有股票所得的最多现金
 * dp[i][1][1]表示第i天第j次不持有股票所得的最多现金
 */
class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int j = 1; j <= k; j++) {
            dp[0][j][0] = -prices[0];
        }

        for (int i = 1; i <= prices.length - 1; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }
        return dp[prices.length - 1][k][1];
    }
}
