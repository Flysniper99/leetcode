package Greedy;

/**
 * 合并后数组中的最大元素
 */
class Solution_2789 {
    public long maxArrayValue(int[] nums) {
        long[] num = new long[nums.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = nums[i];
        }
        int right = num.length - 1;
        for (int i = num.length - 1; i > 0; ) {
            if (num[i] >= num[i - 1]) {
                right = i - 1;
                num[right] = num[i] + num[i - 1];
                i = right;
            } else {
                right = i - 1;
                i = right;
            }
        }
        return num[right];
    }
}
