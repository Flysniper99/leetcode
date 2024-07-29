/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/29 17:38
 * @since : 1.0
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
                if (cnt == 2) {
                    index = i + 1;
                }
            } else {
                if (cnt > 2) {
                    for (int j = 0; j < n - i; j++) {
                        nums[index + j] = nums[i + j];
                    }
                    cnt = 1;
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
