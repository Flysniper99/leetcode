package DynamicProgramming;

/**
 * 最大子数组和
 * dp[i]表示以下标i结尾的数组的连续子数组的最大和
 */
class Solution_53 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,-1,-2};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length - 1; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
            System.out.print(dp[i] + " ");
        }
        System.out.print("\n");
        return Math.max(res, nums[0]);
    }
}
