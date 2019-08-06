package linkedlist.first;

import linkedlist.ListNode;

public class LC203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode p = head;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    public ListNode removeElementsDummyHeader(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode mockNode = new ListNode(-1);
        mockNode.next = head;

        ListNode p = mockNode;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return mockNode.next;
    }

}
