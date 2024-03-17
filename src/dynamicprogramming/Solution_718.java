package dynamicprogramming;

/**
 * 最长重复子数组
 * dp[i][j]表示以nums1[i], nums2[j]为结尾的数组，它们的最长重复子数组长度
 */
class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int res = 0;
        
        for (int i = 0; i <= nums1.length - 1; i++) {
            if (nums1[i] == nums2[0]) dp[i][0] = 1;
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 0; j <= nums2.length - 1; j++) {
            if (nums2[j] == nums1[0]) dp[0][j] = 1;
            res = Math.max(res, dp[0][j]);
        }

        for (int i = 1; i <= nums1.length - 1; i++) {
            for (int j = 1; j <= nums2.length - 1; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public int findLength_2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
