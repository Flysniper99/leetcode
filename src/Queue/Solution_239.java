package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 单调队列，通过deque实现
 * deque中存的是数组的下标
 */
class Solution_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        //未形成滑动窗口，维持队列单调即可
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        res[0] = nums[dq.getFirst()];
        //形成单调队列，首先需要保证队列单调，同时需要保证单调队列中最大值对应下标存在于滑动窗口内
        for (int i = k; i < nums.length; i++) {
            if (dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            res[i - k + 1] = nums[dq.getFirst()];
        }
        return res;
    }

    public static int[] maxSlidingWindow_2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() < i - k + 1) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}