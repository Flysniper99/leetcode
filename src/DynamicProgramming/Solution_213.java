package DynamicProgramming;

/**
 * 打家劫舍II
 */
class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int res_1 = robFunc(nums, 0, nums.length - 2);
        int res_2 = robFunc(nums, 1, nums.length - 1);
        return  Math.max(res_1, res_2);
    }
    public int robFunc(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
