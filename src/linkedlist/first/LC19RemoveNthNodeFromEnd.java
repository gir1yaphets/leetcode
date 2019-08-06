package linkedlist.first;

import linkedlist.ListNode;

public class LC19RemoveNthNodeFromEnd {
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/320595/Java-solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;

        int length = 0;
        while (p != null) {
            length += 1;
            p = p.next;
        }

        if (length == n) {
            return head.next;
        }

        p = head;

        for (int i = 1; i < length - n; i++) {
            p = p.next;
        }

        p.next = p.next.next;

        return head;
    }
}
