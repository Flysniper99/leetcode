package math;

/**
 * 阶乘后的零
 * 算质因子2和5，其中的较小值为因子10的个数
 */
class Solution_172 {
    public int trailingZeroes(int n) {
        int[] ans = new int[2];
        for (int i = n; i > 0; i--) {
            for (int j = i; j % 5 == 0; j /= 5) {
                ans[0]++;
            }
            for (int j = i; j % 2 == 0; j /= 2) {
                ans[1]++;
            }
        }
        return Math.min(ans[0], ans[1]);
    }
}
