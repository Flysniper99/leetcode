package DynamicProgramming;

import java.util.Arrays;

/**
 * 最长连续递增子序列
 * dp[i]表示以nums[i]为结尾的最长连续递增子序列的长度
 */
class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;

        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
