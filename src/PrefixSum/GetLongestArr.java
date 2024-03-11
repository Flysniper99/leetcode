package PrefixSum;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 平均数为k的最长连续子数组
 * 数组减去k，问题转换成和为0的最长连续子数组
 * 前缀和加hashmap
 */
public class GetLongestArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        int[] nums_k = new int[N];
        for (int i = 0; i < N; i++) {
            nums_k[i] = nums[i] - k;
        }
        System.out.println(getLongestArr(nums_k));
    }

    public static int getLongestArr(int[] nums) {
        HashMap<Long, Integer> preSumFirApp = new HashMap<>();
        long preSum = 0;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumFirApp.containsKey(preSum))
                ans = Math.max(ans, i - preSumFirApp.get(preSum));
            else {
                //和为0时不需要加入到map中
                if (preSum == 0)
                    ans = Math.max(ans, i + 1);
                else
                    preSumFirApp.put(preSum, i);
            }
        }
        return ans;
    }
}
