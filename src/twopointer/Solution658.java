/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : f50040149
 * @date : 2024/8/8 15:08
 * @since : 1.0
 */
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int partition = help(arr, x);
        int left = partition - 1;
        int right = partition;
        while (res.size() < k && left >= 0 && right <= n - 1) {
            if (x - arr[left] <= arr[right] - x) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        if (left == -1) {
            while (res.size() < k) {
                res.add(arr[right]);
                right++;
            }
        }
        if (right == n) {
            while (res.size() < k) {
                res.add(arr[left]);
                left--;
            }
        }
        res.sort((o1, o2) -> {
            return o1 - o2;
        });
        // Collections.sort(res);
        return res;
    }

    public static int help(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
