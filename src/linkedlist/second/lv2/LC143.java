package linkedlist.second.lv2;

import linkedlist.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head, second = slow.next;
        slow.next = null;

        ListNode prev = null, curr = second;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        while (first != null && prev != null) {
            ListNode temp1 = first.next, temp2 = prev.next;

            first.next = prev;
            prev.next = temp1;

            first = temp1;
            prev = temp2;
        }
    }
}
