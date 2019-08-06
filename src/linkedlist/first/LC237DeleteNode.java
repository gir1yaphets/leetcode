package linkedlist.first;

import linkedlist.ListNode;

public class LC237DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
