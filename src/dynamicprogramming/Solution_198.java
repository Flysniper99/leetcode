package dynamicprogramming;

/**
 * 打家劫舍
 */
class Solution_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
