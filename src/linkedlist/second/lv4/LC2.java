package linkedlist.second.lv4;

import linkedlist.ListNode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2);
    }

    private ListNode helper(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2, res = new ListNode(-1);
        ListNode curr = res;
        int incre = 0;

        while (curr1 != null && curr2 != null) {
            ListNode digit = new ListNode(-1);
            int sum = curr1.val + curr2.val + incre;
            if (sum >= 10) {
                digit.val = sum - 10;
                incre = 1;
            } else {
                digit.val = sum;
                incre = 0;
            }

            curr.next = digit;
            curr = curr.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 != null) {
            curr.next = curr1;
        }

        if (curr2 != null) {
            curr.next = curr2;
        }

        while (incre > 0) {
            ListNode next;
            if (curr.next == null) {
                next = new ListNode(0);
            } else {
                next = curr.next;
            }

            int sum = incre + next.val;

            if (sum >= 10) {
                sum -= 10;
                incre = 1;
            } else {
                incre = 0;
            }
            next.val = sum;
            curr.next = next;
            curr = curr.next;
        }

        return res.next;
    }

    /**
     * Simplify for solution
     * @param l1
     * @param l2
     * @return
     */
    private ListNode helper2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr1 = l1, curr2 = l2, curr = res;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int x = curr1 == null ? 0 : curr1.val;
            int y = curr2 == null ? 0 : curr2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return res.next;
    }
}
