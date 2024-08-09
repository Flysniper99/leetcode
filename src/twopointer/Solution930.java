/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/8/9 15:50
 * @since : 1.0
 */
class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        if (help(nums) && goal == 0) {
            return n * (1 + n) / 2;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        while (left <= right && right < n) {
            sum += nums[right];
            while (left <= right && sum == goal) {
                res++;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res;
    }

    public boolean help(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
