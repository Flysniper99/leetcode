/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/26 20:18
 * @since : 1.0
 */
class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
                left++;
                right--;
            } else if (nums[left] < nums[right]) {
                left++;
            }
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
