/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/31 19:25
 * @since : 1.0
 */
class Solution424 {
    public static void main(String[] args) {
        String s = "AABA";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = 0;
        int[] cnt = new int[26];
        int maxCnt = 0;

        for (; right < n; right++) {
            cnt[ch[right] - 'A']++;
            maxCnt = Math.max(maxCnt, cnt[ch[right] - 'A']);
            if (maxCnt + k < right - left + 1) {
                cnt[ch[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
