/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024- . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package twopointer;

/**
 * @author : f50040149
 * @date : 2024/7/30 11:11
 * @since : 1.0
 */
class Solution143 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        ListNode head = help(nums);
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int index = len / 2 + 1;
        ListNode cur2 = head;
        for (int i = 0; i < index - 1; i++) {
            cur2 = cur2.next;
        }
        ListNode head2 = cur2.next;
        cur2.next = null;

        ListNode head3 = reverseList(head2);
        mergeList(head, head3);
    }

    //反转后原链表没了，需要注意
    public static ListNode reverseList(ListNode head) {
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

    public static void mergeList(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            ListNode temp1 = cur1.next;
            ListNode temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
    }

    //数组转链表
    private static ListNode help(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if (i == nums.length - 1) {
                cur.next = null;
            }
        }
        return dummy.next;
    }
}
