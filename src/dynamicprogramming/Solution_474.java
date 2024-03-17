package dynamicprogramming;

/**
 * 一和零
 * 该问题的背包是个二维背包，dp数组含义是装满背包最多用多少物品
 */
class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= strs.length - 1; i++) {
            for (int j = m; j >= count(strs[i])[0]; j--) { //两层for遍历二维背包
                for (int k = n; k >= count(strs[i])[1]; k--) {
                    //注意递推公式与常规背包的差异
                    dp[j][k] = Math.max(dp[j][k], dp[j - count(strs[i])[0]][k - count(strs[i])[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public int[] count (String s) {
        int cnt_0 = 0;
        int cnt_1 = 0;
        char[] ch = s.toCharArray();
        for (char i : ch) {
            if (i == '0'){
                cnt_0++;
            }else {
                cnt_1++;
            }
        }
        return new int[]{cnt_0, cnt_1};
    }
}