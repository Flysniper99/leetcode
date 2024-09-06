package dailyque;

import java.util.Arrays;
import java.util.List;

class Solution2860 {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        int[] newNum = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            newNum[i] = nums.get(i);
        }
        Arrays.sort(newNum);
        boolean judge = false;
        for (int i = 0; i < n - 1; i++) {
            if (newNum[i] == 0) {
                judge = true;
            }
            if (i + 1 > newNum[i] && i + 1 < newNum[i + 1]) {
                res++;
            }
        }
        if (n > newNum[n - 1]) {
            res++;
        }
        if (!judge && n != 1) {
            res++;
        }
        return res;
    }
}