package linkedlist.second.lv5;

import linkedlist.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        return helper(head, m, n);
    }

    private ListNode helper(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode rev = null, prev = null;
        ListNode next = null;
        int count = 0;

        while (count < m - 1) {
            count += 1;
            curr = curr.next;
        }

        rev = curr.next;
        ListNode first = curr.next;

        while (count <= n - 1) {
            next = rev.next;
            rev.next = prev;

            prev = rev;
            rev = next;

            count += 1;
        }

        if (first != null) {
            first.next = next;
        }

        curr.next = prev;

        return dummy.next;
    }
}
