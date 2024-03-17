package dynamicprogramming;

/**
 * 两个字符串的删除操作
 * dp[i][j]表示长度为[0-i]的ch1和长度为[0-j]的ch2要相等，所需要删除元素的最少次数
 * 关于递推公式，当ch1[i] == ch2[j]时，dp[i][j] = dp[i - 1][j - 1]。
 * 当ch1[i] != ch2[j]时，有三种状态
 */
class Solution_583 {
    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "ab";
        System.out.println(minDistance_3(word1, word2));
    }
    public int minDistance(String word1, String word2) { //转换成最长公共子序列问题
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp = new int[ch1.length][ch2.length];

        for (int i = 0; i <= ch1.length - 1; i++) {
            if (ch1[i] == ch2[0]) {
                for (int j = i; ;j++) {
                    dp[j][0] = 1;
                    if (j == ch1.length - 1) break;
                }
            }
        }
        for (int i = 0; i < ch2.length - 1; i++) {
            if (ch2[i] == ch1[0]) {
                for (int j = i; ; j++) {
                    dp[0][j] = 1;
                    if (j == ch2.length  - 1) break;
                }
            }
        }

        for (int i = 1; i <= ch1.length - 1; i++) {
            for (int j = 1; j <= ch2.length - 1; j++) {
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return ch1.length + ch2.length - dp[ch1.length - 1][ch2.length - 1] * 2;
    }

    public static int minDistance_2(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp = new int[ch1.length][ch2.length];
        /*
        初始化代码
        dp[i][0]表示长度为[0-i]的ch1和ch2[0]要相等，需要删除的最少次数
         */
        for (int i = 0; i <= ch1.length - 1; i++) {
            if (ch1[i] == ch2[0]) {
                for (int j = i; ; j++) {
                    dp[j][0] = j;
                    if (j == ch1.length - 1) break;
                }
                break;
            } else {
                dp[i][0] = i + 2;
            }
        }
        for (int i = 0; i <= ch2.length - 1; i++) {
            if (ch2[i] == ch1[0]) {
                for (int j = i; ; j++) {
                    dp[0][j] = j;
                    if (j == ch2.length - 1) break;
//                    System.out.print(dp[j][0]);
                }
                break;
            } else {
                dp[0][i] = i + 2;
            }
//            System.out.print(dp[0][i]);
        }

        for (int i = 1; i <= ch1.length - 1; i++) {
            for (int j = 1; j <= ch2.length - 1; j++) {
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[ch1.length - 1][ch2.length - 1];
    }

    public static int minDistance_3(String word1, String word2) {
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
                            Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[ch1.length][ch2.length];
    }
}
