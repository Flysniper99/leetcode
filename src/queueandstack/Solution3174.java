package queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution3174 {
    public String clearDigits(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                stack.addLast(s.charAt(i));
            } else {
                stack.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
