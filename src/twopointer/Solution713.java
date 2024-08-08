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
        int[] nums = new int[] {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        System.out.println(numSubarrayProductLessThanK(nums, 19));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int product = 1;
        while (right < n) {
            product *= nums[right];
            if (product < k) {
                if (right - left + 1 == 1) {
                    res++;
                } else {
                    res += 2;
                }
            } else {
                if (nums[right] < k) {
                    res++;
                    while (product >= k) {
                        product /= nums[left];
                        left++;
                    }
                    if (right - left + 1 > 1) {
                        res++;
                    }
                } else {
                    product = 1;
                    left = right + 1;
                }
            }
            right++;
        }
        if (left < right && right == n) {
            res += right - left - 2;
        }
        return res;
    }
}
