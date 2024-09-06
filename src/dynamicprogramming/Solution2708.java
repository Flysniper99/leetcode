package dynamicprogramming;

class Solution2708 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,-1,-5,2,5,-9};
        System.out.println(maxStrength(nums));
    }
    public static long maxStrength(int[] nums) {
        int n = nums.length;
        long max = nums[0];
        long min = nums[0];
        for (int i = 1; i < n; i++) {
            long temp1 = max;
            long temp2 = min;
            max = Math.max(Math.max(temp1 * nums[i], temp2 * nums[i]), Math.max(temp1, nums[i]));
            min = Math.min(Math.min(temp2 * nums[i], temp1 * nums[i]), Math.min(temp2, nums[i]));
        }
        return max;
    }
}