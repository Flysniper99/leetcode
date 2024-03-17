package dynamicprogramming;

import java.util.Scanner;

/**
 * 完全背包问题
 * 与01背包区别在于背包容量遍历顺序（针对一维数组的写法）
 * 二维的写法不用考虑遍历顺序,较为复杂
 */
public class CompletePack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
//        int[] weight = new int[] {1, 3, 4};
//        int[] value = new int[] {15, 20, 30};
        System.out.println(completePack_2(weight, value, V));
    }
    public static int completePack(int[] weight, int[] value, int packSize) { //一维数组写法，与01背包区别在于背包遍历顺序为前向遍历
        int[] dp = new int[packSize + 1];
        //物品和背包遍历顺序可以改变
        for (int i = 0; i <= weight.length - 1; i++) {
            for (int j = weight[i]; j <= packSize; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[packSize];
    }

    public static int completePack_2(int[] weight, int[] value, int packSize) {
        int[][] dp = new int[weight.length][packSize + 1];
        //初始化，包括第一行和第一列的初始化
        for (int j = 0; j <= packSize; j++) {
            for (int k = 1; k * weight[0] <= j; k++) {
                dp[0][j] = k * value[0];
            }
//            System.out.println(dp[0][j] + " ");
        }
//        System.out.println("\n");

        for (int i = 1; i <= weight.length - 1; i++) {
            for (int j = 1; j <= packSize; j++) {
                /*
                当背包容量为j时，此时对于遍历到的物品i， 有两种放和不放两种情况
                不放时dp[i][j] = dp[i - 1][j]
                放物品i时存在放不放的了和放多少个的情况，对应于下面的if-else两种
                放物品i时的dp算完之后，最后和不放i时的情况取最大值
                */
                int k = 1;
                if (k * weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    for (k = 1; k * weight[i] <= j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i]] + k * value[i]);
                    }
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                /*
                这段代码是上面逻辑的优化版
                 */
//                for (int k = 1; ; k++) {
//                    if (k * weight[i] > j) break;
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i]] + k * value[i]);
//                }
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
//                System.out.println(dp[i][j] + " ");
            }
//            System.out.println("\n");
        }
        return dp[weight.length - 1][packSize];
    }
}
