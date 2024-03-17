package dynamicprogramming;

/**
 * 不同的二叉搜索树
 */
class Solution_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  //j从1到i，分别作为根节点，计算二叉搜索树的种类，累加到dp[i]
                dp[i] += dp[j - 1] * dp[i - j]; //递推公式需要画图理解
            }
        }
        return dp[n];
    }
}
