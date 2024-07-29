/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.Arrays;

/**
 * @author : f50040149
 * @date : 2024/7/29 17:38
 * @since : 1.0
 */
public class Solution80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int res = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        if (n == 2) {
            return n;
        }
        int index = 0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
                if (i == n - 1) {
                    index = index - 1;
                }
                if (cnt == 2) {
                    index = i + 1;
                }
            } else {
                if (cnt > 2) {
                    for (int j = 0; j < n - i; j++) {
                        nums[index + j] = nums[i + j];
                    }
                    n = n - (i - index);
//                    for (int j = n - 1; j > n - i + index - 1; j--) {
//                        nums[j] = 0;
//                    }
                    cnt = 1;
                    i = index;
                } else if (cnt < 2) {
                    index++;
                } else {
                    cnt = 1;
                }
            }
        }
        return index + 1;
    }
}
