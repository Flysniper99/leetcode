package string;

import java.util.Arrays;

class Solution_395 {
    public int longestSubstring(String s, int k) {
        int[] charCount = new int[26];
        char[] ch = s.toCharArray();
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            Arrays.fill(charCount, 0);
            int chCnt = 0;
            int chkCnt = 0;
            int left = 0;
            for (int right = 0; right < ch.length; right++) {
                int temp = ch[right] - 'a';
                charCount[temp]++;
                if (charCount[temp] == 1) chCnt++;
                if (charCount[temp] == k) chkCnt++;
                while (chCnt > i) {
                    int temp_2 = ch[left++] - 'a';
                    charCount[temp_2]--;
                    if (charCount[temp_2] == 0) chCnt--;
                    if (charCount[temp_2] == k - 1) chkCnt--;
                }
                if (chCnt == chkCnt) res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }
}
