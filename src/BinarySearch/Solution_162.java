package BinarySearch;

class Solution_162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}