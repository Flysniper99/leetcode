/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : f50040149
 * @date : 2024/7/30 9:48
 * @since : 1.0
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode index = head;
        while (index != null) {
            if (index.val >= x) {
                deque.addLast(index.val);
            }
            index = index.next;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val < x) {
                slow = slow.next;
            }
            if (fast.val < x) {
                int temp = fast.val;
                fast.val = slow.val;
                slow.val = temp;
            }
            fast = fast.next;
        }
        ListNode index2 = head;
        while (index2 != null) {
            if (index2.val >= x) {
                index2.val = deque.removeFirst();
            }
            index2 = index2.next;
        }
        return head;
    }
}
