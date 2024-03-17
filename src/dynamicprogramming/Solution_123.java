package dynamicprogramming;

/**
 * 买卖股票的最佳时机III
 * 第i天有五种状态
 * dp[i][0]不做操作
 * dp[i][1]表示第i天第一次持有股票所得的最多现金
 * dp[i][2]表示第i天第一次不持有股票所得的最多现金
 * dp[i][3]表示第i天第二次持有股票所得的最多现金
 * dp[i][4]表示第i天第二次不持有股票所得的最多现金
 * 可以模2实现状态压缩
 */
class Solution_123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i <= prices.length - 1; i++) {
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
            dp[i % 2][2] = Math.max(dp[(i - 1) % 2][2], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][3] = Math.max(dp[(i - 1) % 2][3], dp[(i - 1) % 2][2] - prices[i]);
            dp[i % 2][4] = Math.max(dp[(i - 1) % 2][4], dp[(i - 1) % 2][3] + prices[i]);
        }
        return dp[(prices.length - 1) % 2][4];
    }
}
