package queueandstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        //先构建滑动窗口，维护单调队列，最好存下标
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.getFirst()];
        for (int i = k; i < n; i++) {
            //左指针移动
            if (nums[i - k] == nums[deque.getFirst()]) {
                deque.removeFirst();
            }
            //右指针移动
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            res[i - k + 1] = nums[deque.getFirst()];
        }
        return res;
    }
}

