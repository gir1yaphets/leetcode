package linkedlist.second.lv2;

import linkedlist.ListNode;

public class LC24 {
    public ListNode swapPairs(ListNode head) {

        //#1.Iterator solution
        /* return helper(head); */

        //#2.My recursion solution
        /*
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, curr = head;
        helperRecursion(prev, curr, head.next);

        return dummy.next;
        */

        //#3.Better recursion
        return helperRecursionBetter(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, curr = head, next = head.next;

        while (curr != null && curr.next != null) {
            ListNode temp = next.next;
            curr.next = temp;
            next.next = curr;
            prev.next = next;

            prev = curr;
            curr = curr.next;
            //prev.next = curr; 错误写法:不能更新prev.next了 prev当前指向的dummy，如果更新prev.next之前的swap操作就白做了
            if (curr != null) {
                next = curr.next;
            }
        }

        return dummy.next;
    }

    /**
     * 这种写法应该算不上递归，递归应该是先一直走到底然后再归回来
     * @param prev
     * @param curr
     * @param next
     */
    private void helperRecursion(ListNode prev, ListNode curr, ListNode next) {
        if (curr == null || curr.next == null) {
            return;
        }

        ListNode temp = next.next;
        next.next = curr;
        prev.next = next;
        curr.next = temp;

        if (curr != null && curr.next != null) {
            helperRecursion(curr, curr.next, curr.next.next);
        }
    }

    private ListNode helperRecursionBetter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        /**
         * 一定注意这两行的顺序,如果先写next.next = head, 因为当前head.next仍然指向next，所以就会成为一个环从而导致死循环
         * helperRecursionBetter方法return的是交换后的前节点,所以当前节点的下一个节点都是指向下一次交换后的前节点
         */
        head.next = helperRecursionBetter(head.next.next);
        next.next = head;

        return next;
    }
}
