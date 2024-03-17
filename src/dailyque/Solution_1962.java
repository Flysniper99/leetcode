package dailyque;

import java.util.PriorityQueue;

class Solution_1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int pile : piles) {
            pq.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int temp = pq.remove();
            temp -= temp / 2;
            pq.add(temp);
        }
        int res = 0;
        while (!pq.isEmpty()) {
             res += pq.remove();
        }
        return  res;
    }
}