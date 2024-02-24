package DynamicProgramming;

/**
 * 最佳买卖股票时机含冷冻期
 * 定义了五种状态，dp数组表示该状态对应的最大现金
 * dp[i][0]表示买
 * dp[i][1]表示持有（不包含买）
 * dp[i][2]表示卖
 * dp[i][3]表示卖后冷冻期
 * dp[i][4]表示不持有（不包含冷冻期）
 */
class Solution_309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = -prices[0];
        dp[0][1] = -prices[0];

        for (int i = 1; i <= prices.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][4] - prices[i], dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0] + prices[i]);
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3]);
        }
        return Math.max(dp[prices.length - 1][2],
                Math.max(dp[prices.length - 1][3], dp[prices.length - 1][4]));
    }

    public int maxProfit_2(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);

        for (int i = 2; i <= prices.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
