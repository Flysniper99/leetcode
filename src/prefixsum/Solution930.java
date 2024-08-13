/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : f50040149
 * @date : 2024/8/12 15:39
 * @since : 1.0
 */
class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for (int i : nums) {
            //先put再计算preSum，先put是因为preSum中会出现==goal的情况，最后一个preSum不需要加入map中
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            preSum += i;
            res += map.getOrDefault(preSum - goal, 0);
        }
        return res;
    }
}