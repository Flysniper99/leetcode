package dynamicprogramming;

/**
 * 不同路径II
 */
class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //dp数组初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
                continue;
            }
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < m; j++) {   //初始行出现障碍物，该位置及后面的位置dp都为0
                    dp[j][0] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
                continue;
            }
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
