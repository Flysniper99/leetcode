/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : f50040149
 * @date : 2024/8/7 15:46 //基于vue.js的仿QQ聊天室
 * @since : 1.0
 */
class Solution438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int[] map = new int[26];
        int n = charS.length;
        int m = charP.length;
        List<Integer> res = new ArrayList<>();
        if (m > n) {
            return new ArrayList<>();
        }
        for (char i : charP) {
            map[i - 'a']++;
        }
        int left = 1;
        int right = m;
        for (int i = 0; i < m; i++) {
            map[charS[i] - 'a']--;
        }
        if (help(map)) {
            res.add(0);
        }
        for (; left < n - m + 1; left++) {
            map[charS[left - 1] - 'a']++;
            map[charS[right] - 'a']--;
            if (map[charS[left - 1] - 'a'] != 0 || map[charS[right] - 'a'] != 0) {
                right++;
                continue;
            } else {
                if (help(map)) {
                    res.add(left);
                }
            }
            right++;
        }
        return res;
    }

    public static boolean help(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
