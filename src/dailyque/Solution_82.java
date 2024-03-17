package dailyque;

class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (pre.next != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}