package dynamicprogramming;

/**
 * 01背包问题
 */
public class Pack01 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int M = sc.nextInt();
//        int N = sc.nextInt();
//        int[] weight = new int[M];
//        int[] value = new int[M];
//        for (int i = 0; i < M; i++) {
//            weight[i] = sc.nextInt();
//        }
//        for (int i = 0; i < M; i++) {
//            value[i] = sc.nextInt();
//        }
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        System.out.println(pack01_2(weight, value, 4));
    }
    public static int pack01(int[] weight, int[] value, int packSize) {
        int[][] dp = new int[weight.length][packSize + 1]; //dp[i][j]表示0-i个物品任取放入到容量为j的背包中得到的最大价值
        for (int j = weight[0]; j <= packSize; j++) {  //初始化第一列，即dp[i][0] = 0;第一行从背包容量>=weight[0]时初始化为dp[0][j] = value[0]
            dp[0][j] = value[0];
        }

        for (int i = 1; i <= weight.length - 1; i++) { //遍历顺序为先物品再背包，反之亦可
            for (int j = 1; j <= packSize; j++) {
                if (j < weight[i]) dp[i][j] = dp[i - 1][j]; //这里需要注意判断一下
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);  //递推公式，两种情况
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[weight.length - 1][packSize];
    }

    public static int pack01_2(int[] weight, int[] value, int packSize) { //滚动数组实现状态压缩
        int[] dp = new int[packSize + 1];  //一维数组，省略了初始化代码，dp[j]初始化为0

        for (int i = 0; i <= weight.length - 1; i++) {  //遍历循序必须先物品再背包，背包倒序遍历
            for (int j = packSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j- weight[i]] + value[i]);
                System.out.print(dp[j] + " ");
            }
            System.out.println("\n");
        }
        return dp[packSize];
    }
}
