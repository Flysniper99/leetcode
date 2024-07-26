/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.Arrays;

/**
 * @author : f50040149
 * @date : 2024/7/26 10:05
 * @since : 1.0
 */
class Solution_31 {
    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n;
        //从后往前遍历，找到第一个降序的连续的两个数
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        //从后往前遍历，找到第一个比index位置的num大的数并交换位置
        for (int i = n - 1; i >= index + 1; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //将index后的数由降序变为升序
        if (index == n) {
            help(nums, 0, n - 1);
        } else {
            help(nums, index + 1, n - 1);
        }
    }

    public static void help(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
