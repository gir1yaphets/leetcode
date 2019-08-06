package linkedlist.second.lv1;

import linkedlist.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return helper1(head, n);
    }

    private ListNode helper1(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = dummy;

        for (int i = 0; i <= len; i++) {
            if (i == len - n) {
                curr.next = curr.next.next;
                break;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
