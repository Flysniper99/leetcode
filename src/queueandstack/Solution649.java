package queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.addLast(i);
            } else {
                dire.addLast(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int temp1 = radiant.removeFirst();
            int temp2 = dire.removeFirst();
            if (temp1 < temp2) {
                radiant.addLast(temp1 + n);
            } else {
                dire.addLast(temp2 + n);
            }
        }
        return radiant.isEmpty()? "Dire" : "Radiant";
    }
}
