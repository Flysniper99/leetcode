package dynamicprogramming;

/**
 * 零钱兑换II
 * 完全背包
 * dp数组含义是装满背包的方法数
 * 使用一维数组，遍历顺序必须是先物品再是背包
 */
class Solution_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //注意初始化
        //组合数先遍历物品再遍历背包，可以把二维矩阵和一维数组画出来对比就可以理解
        for (int i = 0; i <= coins.length - 1; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]]; //注意递推公式差异
            }
        }
        return dp[amount];
    }
}
