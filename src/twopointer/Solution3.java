/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : f50040149
 * @date : 2024/7/30 20:14
 * @since : 1.0
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int left = 0;
        map.put(ch[0], 0);
        for (int right = 1; right < n; right++) {
            if (map.containsKey(ch[right])) {
                //abba，注意left的取值情况，避免left回退
                left = Math.max(left, map.get(ch[right]) + 1);
            }
            //map中不存在当前元素时，自然添加进去，存在当前元素时，需要更新该元素的最新下标到map中
            map.put(ch[right], right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
