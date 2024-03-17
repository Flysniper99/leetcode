package dailyque;

class Solution_2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        var dp = new long[m + 1][n + 1];
        for (var p : prices) dp[p[0]][p[1]] = p[2];
        for (var i = 1; i <= m; i++)
            for (var j = 1; j <= n; j++) {
                for (var k = 1; k <= j / 2; k++) dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]); // 垂直切割
                for (var k = 1; k <= i / 2; k++) dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]); // 水平切割
            }
        return dp[m][n];
    }
}
