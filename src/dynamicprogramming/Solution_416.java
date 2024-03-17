package dynamicprogramming;

/**
 * 分割等和子集
 */
class Solution_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;

        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[sum / 2] == sum / 2) return true;
        }
        return dp[sum / 2] == sum / 2;
    }
}
