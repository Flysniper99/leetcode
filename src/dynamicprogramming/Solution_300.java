package dynamicprogramming;

import java.util.Arrays;

/**
 * 最长递增子序列
 * dp[i]表示以nums[i]为结尾的最长递增子序列的长度
 */
class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;

        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
