import java.util.PriorityQueue;

class Solution_2182 {
    public static void main(String[] args) {
        String s = "cczazcc";
        System.out.println(repeatLimitedString(s, 3));
    }
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] cha = new int[26];
        char[] sta = s.toCharArray();
        for (Character i : sta) {
            cha[i - 'a']++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.c - o1.c);
        for (int i = 0; i < 26; i++) {
            if (cha[i] > 0) {     //这里需要做个判断，不然会把其他未出现的字母加入到队列中
                pq.add(new Node((char) (i + 'a'), cha[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node temp = pq.remove();
            if (temp.cnt <= repeatLimit) {
                for (int i = 0; i < temp.cnt; i++) {
                     sb.append(temp.c);
                }
            }else {
                for (int i = 0; i < repeatLimit; i++) {
                     sb.append(temp.c);
                     temp.cnt--;
                }
                if (!pq.isEmpty()) {
                    Node temp_2 = pq.remove();
                    sb.append(temp_2.c);
                    temp_2.cnt--;
                    if (temp_2.cnt > 0) {
                        pq.add(temp_2);
                    }
                    pq.add(temp);
                }
            }
        }
        return sb.toString();
    }

    public static class Node {
        char c;
        int cnt;
        Node(char c, int cnt) {
             this.c = c;
             this.cnt = cnt;
        }
    }
}