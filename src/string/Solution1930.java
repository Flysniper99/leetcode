package string;

import java.util.HashSet;
import java.util.Set;

class Solution1930 {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        int res = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int left = 0;
            int right = len - 1;
            while (left <= len - 1 && s.charAt(left) != i) {
                left++;
            }
            while (right >= 0 && s.charAt(right) != i) {
                right--;
            }
            if (right - left < 2) continue;
            Set<Character> set = new HashSet<>();
            for (int j = left + 1; j < right; j++) {
                set.add(s.charAt(j));
            }
            res += set.size();
        }
        return res;
    }
}