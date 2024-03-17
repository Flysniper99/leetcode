package dailyque;

import java.util.*;

class Solution_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int temp = map.getOrDefault(num, 0);
                map.put(num, ++temp);
            } else {
                map.put(num, 1);
            }
        }
        //对map中的value进行升序排列
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue() - o2.getValue()));
        int[] res = new int[k];
        int cnt = 0;
        for (int i = list.size() - 1; i > list.size() - k  - 1; i--) {
            res[cnt++] = list.get(i).getKey();
        }
        return res;
    }

    //小顶堆
    public static int[] topKFrequent_2(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Integer i : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{i, map.get(i)});
            }
            else {
                if (map.get(i) > Objects.requireNonNull(minHeap.peek())[1]) {
                    minHeap.poll();
                    minHeap.offer(new int[]{i, map.get(i)});
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = Objects.requireNonNull(minHeap.poll())[0];
        }
        return res;
    }
}