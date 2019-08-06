package linkedlist.first;

import linkedlist.ListNode;

public class LC876MiddleLinkedList {
    //https://leetcode.com/problems/middle-of-the-linked-list/discuss/324647/Java-solution
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
