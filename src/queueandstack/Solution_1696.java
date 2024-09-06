package queueandstack;

import java.util.Deque;
import java.util.LinkedList;

class Solution_1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Deque<Integer> dq = new LinkedList<>();
        dp[0] = nums[0];
        //i为滑动窗口的右边界点，在未形成滑动窗口时可在左边添加虚拟元素构成滑动窗口
        for (int i = 1; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() < i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dp[i - 1] > dp[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i - 1);
            dp[i] = dp[dq.getFirst()] + nums[i];
        }
        return dp[nums.length - 1];
    }
}
