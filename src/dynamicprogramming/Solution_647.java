package dynamicprogramming;

/**
 * 回文子串
 * dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，
 * 如果是dp[i][j]为true，否则为false。
 */
class Solution_647 {
    public int countSubstrings(String s) {
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[chs.length][chs.length];
        int res = 0;

        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = i; j <= chs.length - 1; j++) {
                if (chs[i] != chs[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            res++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings_2(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i <= chs.length - 1; i++) {
            res += countSub(chs, i, i, chs.length);
            res += countSub(chs, i, (i + 1), chs.length);
        }
        return res;
    }

    public int countSub(char[] chs, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && chs[i] == chs[j]) {
            res++;
            i--;
            j++;
        }
        return res;
    }
}
