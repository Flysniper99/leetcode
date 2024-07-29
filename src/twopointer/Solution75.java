/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.Arrays;

/**
 * @author : f50040149
 * @date : 2024/7/26 20:18
 * @since : 1.0
 */
class Solution75 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //快慢指针，两个for，一个for把0全部移到左边，一个for把2全部移到右边
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
        }
        for (int i = n - 1; i >= left; i--) {
            if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            }
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
