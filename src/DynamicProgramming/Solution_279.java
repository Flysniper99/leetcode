package DynamicProgramming;

import java.util.Arrays;

/**
 * 完全平方数
 * 完全背包
 * dp数组表示装满背包最少需要的物品数
 */
class Solution_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    public static  int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1); //因为要求最少数量，所以数组初始化为较大值
        dp[0] = 0;
        int bound = 0;
        for (int i = 1; ; i++) {
            if (i * i > n) {
                bound = i - 1;
                break;
            }
        }
//        System.out.println(bound);
        for (int i = 1; i <= bound; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                System.out.print(dp[j] + " ");
            }
            System.out.print("\n");
        }
        return dp[n];
    }
}
