package dynamicprogramming;

/**
 * 最后一块石头的重量II
 * 问题转化为把石头分为重量尽可能相等的两堆，然后碰撞取差值
 */
class Solution_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i <= stones.length - 1; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
