package linkedlist.second.lv1;

import linkedlist.ListNode;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
