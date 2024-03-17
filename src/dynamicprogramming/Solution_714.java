package dynamicprogramming;

/**
 * 买卖股票的最佳时机含手续费
 * dp[i][0]表示第i天持有股票所得的最多现金
 * dp[i][1]表示第i天不持有股票所得的最多现金，可由i - 1天不持有股票和第i天卖出股票（卖出时算手续费）两种状态推导
 * 可以模2实现状态压缩
 */
class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i <= prices.length - 1; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] - prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] + prices[i] - fee);
        }
        return dp[(prices.length - 1) % 2][1];
    }
}
