package dynamicprogramming;

/**
 * 整数拆分
 */
class Solution_343 {
    public static void main(String[] args) {
        int res = integerBreak(10);
        System.out.println(res);
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1]; //dp[i]表示拆分数i可得到的最大乘积
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
