package DynamicProgramming;

/**
 * 最长公共子序列
 * 将字符串转化为字符数组
 * dp[i][j]表示长度为[0-i]的txt1和长度为[0-j]的txt2的最长公共子序列
 */
class Solution_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();
        int[][] dp = new int[txt1.length][txt2.length];
//        for (int i = 0; i <= txt1.length - 1; i++) {
//            if (txt1[i] == txt2[0]) {
//                for (int j = i; ; j++) {
//                    dp[j][0] = 1;
//                    if (j == txt1.length - 1) break;
//                }
//            }
//        }
//        for (int i = 0; i <= txt2.length - 1; i++) {
//            if (txt2[i] == txt1[0]) {
//                for (int j = i; ; j++) {
//                    dp[0][j] = 1;
//                    if (j == txt2.length - 1) break;
//                }
//            }
//        }
        for (int i = 0; i <= txt1.length - 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= txt1.length - 1 && txt1[i] != txt2[0]; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= txt2.length - 1; j++) {
            dp[0][j] = 1;
        }
        for (int j = 0; j <= txt2.length - 1 && txt2[j] != txt1[0]; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= txt1.length - 1; i++) {
            for (int j = 1; j <= txt2.length - 1; j++) {
                if (txt1[i] == txt2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[txt1.length - 1][txt2.length - 1];
    }
}
