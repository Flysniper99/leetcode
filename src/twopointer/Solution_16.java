/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.Arrays;

/**
 * @author : f50040149
 * @date : 2024/7/25 17:08
 * @since : 1.0
 */
public class Solution_16 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 8, 9, 10};
        int target = 16;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] res = new int[2];
        //记录当前差值以及三数和
        res[0] = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                // res[0] = Math.min(res[0], nums[i] + nums[i + 1] + nums[i + 2] - target);
                if (nums[i] + nums[i + 1] + nums[i + 2] - target < res[0]) {
                    res[0] = nums[i] + nums[i + 1] + nums[i + 2] - target;
                    res[1] = nums[i] + nums[i + 1] + nums[i + 2];
                }
                break;
            }
            if (nums[i] + nums[n - 2] + nums[n - 1] < target) {
                // res[0] = Math.min(res[0], target - (nums[i] + nums[n - 2] + nums[n - 1]));
                if (nums[i] + nums[n - 2] + nums[n - 1] - target < res[0]) {
                    res[0] = nums[i] + nums[n - 2] + nums[n - 1] - target;
                    res[1] = nums[i] + nums[n - 2] + nums[n - 1];
                }
                continue;
            }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > target) {
                    if (nums[i] + nums[left] + nums[right] - target < res[0]) {
                        res[0] = nums[i] + nums[left] + nums[right] - target;
                        res[1] = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    if (target - nums[i] - nums[left] - nums[right] < res[0]) {
                        res[0] = target - nums[i] - nums[left] - nums[right];
                        res[1] = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                } else {
                    return nums[i] + nums[left] + nums[right];
                }
            }
        }
        return res[1];
    }
}
