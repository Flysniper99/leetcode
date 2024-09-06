package prefixsum;

class Solution_303 {
    int[] preSum;
    public Solution_303(int[] nums) {
        int n = nums.length;
        preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 0; i < n - 1; i++) {
            preSum[i + 1] = preSum[i] + nums[i + 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return preSum[right];
        } else {
            return preSum[right] - preSum[left - 1];
        }
    }
}
