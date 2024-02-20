package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    public static  int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
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
