package binarysearch;

/**
 * 二分分为定义域二分和值域二分，值域二分知道了数组里面的最大最小值，作为二分索引，统计
 * 数组里面小于等于mid值的元素个数cnt
 */
class Solution_162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}