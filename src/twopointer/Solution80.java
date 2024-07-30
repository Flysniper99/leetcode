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
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int index = 0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                //计数，以及index指针指向重复两遍后的位置
                cnt++;
                if (cnt == 2) {
                    index = i + 1;
                }
                //边界条件
                if (i == n - 1) {
                    index = index - 1;
                }
            } else {
                //i及以后位置的所有元素向前覆写，并缩减n便于输出
                if (cnt > 2) {
                    for (int j = 0; j < n - i; j++) {
                        nums[index + j] = nums[i + j];
                    }
                    n = n - (i - index);
                    //计数更新，i从index开始便利
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
