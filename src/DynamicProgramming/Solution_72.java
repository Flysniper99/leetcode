package DynamicProgramming;

/**
 * 编辑距离
 */
class Solution_72 {
    public int minDistance(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];

        for (int i = 0; i <= ch1.length; i++) dp[i][0] = i;
        for (int j = 0; j <= ch2.length; j++) dp[0][j] = j;

        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1,
                            Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[ch1.length][ch2.length];
    }
}
