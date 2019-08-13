package linkedlist.second.lv4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import linkedlist.ListNode;

public class LC445 {
    public ListNode deleteDuplicates(ListNode head) {
        return helper(head);
    }

    public ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode(-1);
        ListNode curr = res;
        ListNode org = head;
        List<Integer> unique = new LinkedList<>();
        Set<Integer> existed = new HashSet<>();

        while (org != null && org.next != null) {
            if (!unique.contains(org.val)) {
                unique.add(org.val);
            }
            if (org.val == org.next.val) {
                existed.add(org.val);
            }
            org = org.next;
        }

        //last node
        if (!unique.contains(org.val)) {
            unique.add(org.val);
        }
        for (int value : existed) {
            if (unique.contains(value)) {
                unique.remove(unique.indexOf(value));
            }
        }

        for (int value : unique) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return res.next;
    }

    private ListNode helper2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(head.val == 0 ? -1 : 0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        ListNode pointer = dummy;

        while (curr != null && curr.next != null) {
            //The condition for a unique node: prev.val != curr.val != curr.next.val
            if (prev.val != curr.val && curr.val != curr.next.val) {
                pointer.next = curr;
                pointer = pointer.next;
            }
            prev = curr;
            curr = curr.next;
        }

        if (prev.val != curr.val) {
            pointer.next = curr;
        } else {
            pointer.next = null; //For [1,1]
        }

        return dummy.next;
    }

    private ListNode helper3(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(head.val == 0 ? -1 : 0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;

        while (fast != null) {
            //Find the last duplicated node, e.g. [1->1->1->2], fast point to 1 before 2
            while (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }

            //For the initial condition, slow.next = fast, if slow.next != fast any more, it suggests that fast moves forward
            if (slow.next != fast) {
                slow.next = fast.next;//skip the duplicated node
                fast = slow.next; //reposition fast to slow.next
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return dummy.next;
    }
}
