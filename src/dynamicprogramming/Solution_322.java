package dynamicprogramming;

import java.util.Arrays;

/**
 * 零钱兑换
 * 完全背包
 * dp数组表示装满背包最少需要的物品数
 */
class Solution_322 {
    public static void main(String[] args) {
        int[] coins = new int[] {2};
        System.out.println(coinChange(coins, 3));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= coins.length - 1; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                System.out.print(dp[j] + " ");
            }
            System.out.print("\n");
        }
        return dp[amount] == amount + 1? -1 : dp[amount];
    }
}
