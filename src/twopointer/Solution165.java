/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/30 17:04
 * @since : 1.0
 */
class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int[] nums1 = new int[str1.length];
        int[] nums2 = new int[str2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.parseInt(str2[i]);
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                return -1;
            } else if (nums1[index1] > nums2[index2]) {
                return 1;
            } else {
                index1++;
                index2++;
            }
        }
        if (index1 == nums1.length && index2 == nums2.length) {
            return 0;
        }
        if (index1 == nums1.length && index2 < nums2.length) {
            for (int i = index2; i < nums2.length; i++) {
                if (nums2[i] > 0) {
                    return -1;
                }
            }
        }
        if (index1 < nums1.length && index2 == nums2.length) {
            for (int i = index1; i < nums1.length; i++) {
                if (nums1[i] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
