package dailyque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution_2454 {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(((o1, o2) -> (o1[0] - o2[0])));
        for (int i = 0; i < nums.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < nums[i]) {
                res[minHeap.peek()[1]] = nums[i];
                minHeap.poll();
            }
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i]) {
                minHeap.offer(new int[]{nums[stack.peekFirst()], stack.peekFirst()});
                stack.pollFirst();
            }
            stack.offerFirst(i);
        }
        return res;
    }
}
