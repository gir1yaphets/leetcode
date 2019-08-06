package linkedlist.first;

import java.util.Stack;

import linkedlist.ListNode;

public class LC234PalindromeLinkedList {
    //https://leetcode.com/problems/palindrome-linked-list/discuss/324643/Java-solution
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int length = 0;
        boolean isOdd;

        while (p != null) {
            p = p.next;
            length += 1;
        }

        if (length == 1) {
            return true;
        }

        isOdd = length % 2 == 1;

        p = head;

        Stack<Integer> firstHalf = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (i < length / 2) {
                firstHalf.push(p.val);
            } else {
                if (!isOdd) {
                    if (p.val != firstHalf.pop()) {
                        return false;
                    }
                } else {
                    isOdd = false;
                }
            }
            p = p.next;
        }

        return true;
    }
}
