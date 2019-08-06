package linkedlist.first;

import linkedlist.ListNode;

public class LC83RemoveDuplicatesFromSortedList {
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        List<Integer> existNumbers = new ArrayList<>();
//        ListNode mockNode = new ListNode(-1);
//        mockNode.next = head;
//        ListNode p = mockNode;
//
//        while (p.next != null) {
//            if (existNumbers.contains(p.next.val)) {
//                p.next = p.next.next;
//            } else {
//                existNumbers.add(p.next.val);
//                p = p.next;
//            }
//        }
//
//        return mockNode.next;
//    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        //no need to use list.contains, since it's sorted.
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
