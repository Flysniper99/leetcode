package DynamicProgramming;

/**
 * 不同的子序列
 * dp[i][j]表示长度为[0-i]的chs中长度为[0-j]的cht出现的次数
 * 关于递推公式的理解，当chs[i] == cht[j]时，如果chs[i]用来匹配cht[j]，则
 * dp[i][j] = dp[i - 1][j - 1]，如果chs[i]没有用来匹配cht[j]，相当于删除chs[i],
 * 在[0- i-1]中找
 */
class Solution_115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        int[][] dp = new int[chs.length][cht.length];
        if (chs[0] == cht[0]) dp[0][0] = 1;
        else dp[0][0] = 0;
        for (int i = 1; i <= chs.length - 1; i++) {
            if (chs[i] == cht[0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i <= chs.length - 1; i++) {
            for (int j = 1; j <= cht.length - 1; j++) {
                if (chs[i] == cht[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[chs.length - 1][cht.length - 1];
    }
}
