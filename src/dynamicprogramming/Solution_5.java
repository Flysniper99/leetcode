package dynamicprogramming;

/**
 * 最长回文子串
 * dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，
 * 如果是dp[i][j]为true，否则为false。
 * 是回文子串的话，与之前记录的最大回文子串长度进行对比以更新结果
 */
class Solution_5 {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[chs.length][chs.length];
        int temp = 0;
        String res = s.substring(0,1);

        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = i; j <= chs.length - 1; j++) {
                if (chs[i] == chs[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        if (j - i > temp) {
                            temp = j - i;
                            res = s.substring(i, j + 1);
                        }
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i > temp) {
                            temp = j - i;
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
