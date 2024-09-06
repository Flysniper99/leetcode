package queueandstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> index = new ArrayDeque<>();
        //index队列模拟下标变化过程
        for (int i = 0; i < n; i++) {
            index.addLast(i);
        }
        Arrays.sort(deck);
        int[] res = new int[n];
        for (int card : deck) {
            res[index.removeFirst()] = card;
            if (!index.isEmpty()) {
                index.addLast(index.removeFirst());
            }
        }
        return res;
    }
}