package dynamicprogramming;

/**
 * 目标和
 * 数组分成两个子数组，子数组的元素和可以算出来，然后
 * 通过01背包解决，dp数组含义是装满背包有多少种方法
 */
class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum + target) % 2 != 0) return 0;
        if (Math.abs(target) > sum) return 0;
        int packSize = (sum + target) / 2;
        int[] dp = new int[packSize + 1];
        dp[0] = 1; //初始化为1，需要注意
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = packSize; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];  //递推公式注意与常规01背包差异
            }
        }
        return dp[packSize];
    }
}