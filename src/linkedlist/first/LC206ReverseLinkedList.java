package linkedlist.first;

import linkedlist.ListNode;

public class LC206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;

        int length = 0;

        while (p != null) {
            p = p.next;
            length += 1;
        }

        ListNode current = head;

        for (int i = 0; i < length; i++) {
            swapNodeValue(current, length - i);
//            current = current.next;
        }

        return head;
    }

    private void swapNodeValue(ListNode node, int n) {
        ListNode p = node;
        int temp;

        for (int i = 1; i < n; i++) {
            if (p != null && p.next != null) {
                temp = p.next.val;
                p.next.val = p.val;
                p.val = temp;

                p = p.next;
            }
        }
    }
}
