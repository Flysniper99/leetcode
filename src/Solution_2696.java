import java.util.ArrayDeque;
import java.util.Deque;

class Solution_2696 {
    public int minLength(String s) {
        Deque<Character> st = new ArrayDeque<>();
        //st.addFirst(' ');
        for (int i = 0; i < s.length(); i++) {
            if ((!st.isEmpty() && st.getFirst() == 'A' && s.charAt(i) == 'B')
                    || (!st.isEmpty() && st.getFirst() == 'C' && s.charAt(i) == 'D')) {
                st.removeFirst();
            }else {
                st.addFirst(s.charAt(i));
            }
        }
        return st.size() - 1;
    }
}
