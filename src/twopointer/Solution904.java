/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : f50040149
 * @date : 2024/8/9 11:04
 * @since : 1.0
 */
class Solution904 {
    public static void main(String[] args) {
        int[] fruits = new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }

    //相当于求种类数为2的最长子串
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (left <= right && right < n) {
            //map大小小于2时直接加
            if (map.size() < 2) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            } else {
                //大于等于2时，如果map中存在right所指向的键，直接加
                if (map.containsKey(fruits[right])) {
                    map.put(fruits[right], map.get(fruits[right]) + 1);
                    //不存在的话则需要算出当前的长度，同时左指针右移，直到map的大小重新小于2
                } else {
                    int sum = 0;
                    for (Integer value : map.values()) {
                        sum += value;
                        res = Math.max(res, sum);
                    }
                    //注意只有当key对应的value为0时，才可以把键值对删除！！！
                    while (map.size() >= 2) {
                        map.put(fruits[left], map.get(fruits[left]) - 1);
                        if (map.get(fruits[left]) == 0) {
                            map.remove(fruits[left]);
                        }
                        left++;
                    }
                    map.put(fruits[right], 1);
                }
            }
            right++;
        }
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
            res = Math.max(res, sum);
        }
        return res;
    }
}