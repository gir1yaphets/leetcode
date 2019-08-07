package linkedlist.second.lv3;

import linkedlist.ListNode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return helper(headA, headB);
    }

    /**
     * Brute Force solution
     * @param headA
     * @param headB
     * @return
     */
    private ListNode helper(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA, currB = headB;

        while (currA != null) {
            while (currB != null) {
                if (currA == currB) {
                    return currA;
                }

                currB = currB.next;
            }

            currB = headB;
            currA = currA.next;
        }

        return null;
    }

    private ListNode helper2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        int diff = Math.abs(lenA - lenB);

        ListNode currA = headA, currB = headB;

        if (lenA > lenB) {
            while (diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                currB = currB.next;
                diff--;
            }
        }

        while (currA != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len += 1;
            node = node.next;
        }

        return len;
    }
}
