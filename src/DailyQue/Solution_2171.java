package DailyQue;

import java.util.Arrays;

class Solution_2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
        }
        long res = sum;
        for (int i = 0; i < beans.length; i++) {
            res = Math.min(res, sum - (long) beans[i] * ((beans.length) - i));
        }
        return res;
    }
}
