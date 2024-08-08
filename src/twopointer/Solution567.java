/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/8/7 17:53
 * @since : 1.0
 */
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n = ch2.length;
        int m = ch1.length;
        if (m > n) {
            return false;
        }
        int[] map = new int[26];
        for (char i : ch1) {
            map[i - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < n) {
            map[ch2[right] - 'a']--;
            while (left <= right && map[ch2[right] - 'a'] < 0) {
                map[ch2[left] - 'a']++;
                left++;
            }
            right++;
            //right加一了
            if (right - left == m) {
                return true;
            }
        }
        return false;
    }
}