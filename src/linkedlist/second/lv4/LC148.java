package linkedlist.second.lv4;

import linkedlist.ListNode;

/**
 * 这道题自己没写出来 solution是discuss里面的答案
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        //recursion terminator
        if (head == null || head.next == null) return head;

        //step1: cut
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;

        //step2: recursion cut
        ListNode l1 = sort(head);
        ListNode l2 = sort(slow);

        //step3: sort merge
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return head.next;
    }

}
