package dynamicprogramming;

/**
 * 不相交的线
 * 转换成最长公共子序列
 */
class Solution_1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for (int i = 0; i <= nums1.length - 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= nums1.length - 1 && nums1[i] != nums2[0]; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= nums2.length - 1; j++) {
            dp[0][j] = 1;
        }
        for (int j = 0; j <= nums2.length - 1 && nums2[j] != nums1[0]; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= nums1.length - 1; i++) {
            for (int j = 1; j <= nums2.length - 1; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
