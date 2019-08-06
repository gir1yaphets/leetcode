package linkedlist.first;

import linkedlist.ListNode;

public class LC24SwapNodesInPairs {
    //https://leetcode.com/problems/swap-nodes-in-pairs/discuss/325376/Java-solution
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            curr.next = second;
            curr.next.next = first;

            curr = curr.next.next;
        }

        return dummy.next;
    }
}
