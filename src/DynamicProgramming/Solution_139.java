package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 完全背包
 * 物品之间有顺序因此求排列数，先遍历背包再遍历物品
 * dp数组含义是字符串长度为i，能否拆分为一个或多个给定字典元素
 */
class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordD = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true; //初始化为true

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordD.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
