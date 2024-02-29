package DailyQue;

import java.util.HashSet;
import java.util.Set;

class Solution_2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> hs = new HashSet<>();
        int cnt = 0;
        for(String word : words) {
            if (hs.contains(reverse(word))) {
                cnt++;
            }
            hs.add(word);
        }
        return cnt;
    }

    public String reverse(String word) {
        char[] s = word.toCharArray();
        int left = 0;
        int right = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
        return new String(s);
    }
}