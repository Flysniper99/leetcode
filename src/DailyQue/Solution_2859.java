package DailyQue;

import java.util.List;

class Solution_2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            String bs = Integer.toBinaryString(i);
            int cnt = 0;
            for (int j = 0; j < bs.length(); j++) {
                if (bs.charAt(j) == '1') {
                    cnt++;
                }
            }
            if (cnt == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
