/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/26 17:33
 * @since : 1.0
 */

class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        //边界情况
        if (head == null) {
            return null;
        }
        //统计链表长度len
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        //取模得到切割点
        int index = k % len;
        //index为0，则不需后面的反转操作
        if (index == 0) {
            return head;
        }
        //先整体反转
        ListNode newHead1 = reverse(head);
        //得到分开的两个链表头newHead1和newHead2
        ListNode cur1 = newHead1;
        for (int i = 0; i < index - 1; i++) {
            cur1 = cur1.next;
        }
        ListNode newHead2 = cur1.next;
        cur1.next = null;
        //两链表再次反转，并进行拼接
        ListNode newHead3 = reverse(newHead1);
        ListNode newHead4 = reverse(newHead2);
        ListNode cur2 = newHead3;
        for (int i = 0; i < index - 1; i++) {
            cur2 = cur2.next;
        }
        cur2.next = newHead4;
        //返回拼接后的链表
        return newHead3;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

