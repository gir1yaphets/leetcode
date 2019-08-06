package linkedlist.second.lv1;

import linkedlist.ListNode;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        return true;
    }

    public boolean helper(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow, prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode start = head; //注意此时head已经不是最初完整的list了，在reverse slow的时候head也变成了一半
        while (prev != null && start != slow) {
            if (prev.val != start.val) {
                return false;
            }

            prev = prev.next;
            start = start.next;
        }

        return true;
    }
}
