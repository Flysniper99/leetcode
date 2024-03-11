package PrefixSum;

import java.util.HashMap;

/**
 * 和为k的子数组
 * 前缀和
 * hashmap中存前缀和及其出现次数
 */
class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Long, Integer> preSumCount = new HashMap<>();
        int ans = 0;
        long preSum = 0L;
        preSumCount.put(0L, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumCount.containsKey(preSum - k)) {
                ans += preSumCount.get(preSum - k);
            }
            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}