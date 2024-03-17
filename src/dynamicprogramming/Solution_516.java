package dynamicprogramming;

/**
 * 最长回文子序列
 */
class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        char[] chs = s.toCharArray();
        int[][] dp = new int[chs.length][chs.length];
        for (int i = 0; i <= chs.length - 1; i++) {
            dp[i][i] = 1;
        }

        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = i + 1; j <= chs.length - 1; j++) {
                if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][chs.length - 1];
    }
}
