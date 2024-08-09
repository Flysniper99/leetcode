/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/8/8 16:33
 * @since : 1.0
 */
class Solution713 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums, 0));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int product = 1;
        while (left <= right && right < n) {
            product *= nums[right];
            //注意边界条件，窗口左边界不能超过右边界
            while (left <= right && product >= k && left <= n - 1) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
