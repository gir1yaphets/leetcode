package linkedlist.second.lv3;

import linkedlist.ListNode;

public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return helper(l1, l2);
    }

    private ListNode helper(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode curr1 = l1, curr2 = l2, prev1 = dummy;
        while (curr1 != null) {
            ListNode next1 = curr1.next;

            if (curr2 != null) {
                ListNode next2 = curr2.next;
                curr1.next = curr2;
                curr1.next.next = next1;

                prev1 = curr1;
                curr1 = next1;
                curr2 = next2;
            }
        }

        if (curr2 != null) {
            prev1.next = curr2;
        }

        return dummy.next;
    }

    private ListNode helper2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode min, max;

        min = l1.val <= l2.val ? l1 : l2;
        max = l1.val > l2.val ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        dummy.next = min;
        ListNode prev = dummy;

        while (min != null) {
            ListNode nextMin = min.next;

            //错误做法：min.next.next不一定要指向nextMin
//            if (max != null) {
//                ListNode nextMax = max.next;
//                if (min.next != null && min.next.val > max.val) {
//                    min.next = max;
//                    min.next.next = nextMin;
//                    max = nextMax;
//                }
//            }
//            prev = min;
//            min = nextMin;

            if (max != null) {
                ListNode nextMax = max.next;
                if (min.next != null && min.next.val > max.val) {
                    min.next = max;
                }

            }
        }

        if (max != null) {
            prev.next = max;
        }

        return dummy.next;
    }
}
