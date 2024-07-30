/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/30 19:05
 * @since : 1.0
 */
class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        swap(nums, 0, n - 1);
        int index = k % n;
        swap(nums, 0, index - 1);
        swap(nums, index, n - 1);
    }

    public void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
