package DynamicProgramming;

/**
 * 判断子序列
 * dp[i][j]表示长度为[0-i]的chs和长度为[0-j]的cht的最长公共子序列
 */
class Solution_392 {
    public boolean isSubsequence(String s, String t) {  //双指针
        if (s.length() > t.length()) return false;
        if (s.isEmpty()) return true;

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int slowIdx = 0;
        for (int i = 0; i <= cht.length - 1; i++) {
            if (chs[slowIdx] == cht[i]) {
                slowIdx++;
                if (slowIdx == chs.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubsequence_2(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.isEmpty()) return true;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[][] dp = new int[chs.length][cht.length];

        for (int i = 0; i <= chs.length - 1; i++) {
            if (chs[i] == cht[0]) {
                for (int j = i; ; j++) {
                    dp[j][0] = 1;
                    if (j == chs.length - 1) break;
                }
            }
        }
        for (int i = 0; i <= cht.length - 1; i++) {
            if (cht[i] == chs[0]) {
                for (int j = i; ; j++) {
                    dp[0][j] = 1;
                    if (j == cht.length - 1) break;
                }
            }
        }

        for (int i = 1; i <= chs.length - 1; i++) {
            for (int j = 1; j <= cht.length - 1; j++) {
                if (chs[i] == cht[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[chs.length - 1][cht.length - 1] == chs.length;
    }
}
