package twopointer;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        //单调队列来维护滑动窗口的最值，递减维护最小值，递增维护最大值
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        while (left <= right && right < n) {
            //维护最值
            while (!min.isEmpty() && nums[right] < min.getLast()) {
                min.removeLast();
            }
            min.addLast(nums[right]);
            while (!max.isEmpty() && nums[right] > max.getLast()) {
                max.removeLast();
            }
            max.addLast(nums[right]);
            //左指针移动，
            while (!min.isEmpty() && !max.isEmpty() && max.getFirst() - min.getFirst() > limit) {
                if (nums[left] == min.getFirst()) {
                    min.removeFirst();
                }
                if (nums[left] == max.getFirst()) {
                    max.removeFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
