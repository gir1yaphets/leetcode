package linkedlist.second.lv3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import linkedlist.ListNode;

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        List<ListNode> nodeList = new LinkedList<>();
        if (head ==  null) {
            return null;
        }

        ListNode curr = head;

        while (curr != null) {
            if (nodeList.contains(curr)) {
                return curr;
            }
            nodeList.add(curr);
            curr = curr.next;
        }

        return null;
    }

    private ListNode helper2(ListNode head) {
        Map<ListNode, ListNode> nodeMap = new HashMap<>();
        if (head ==  null) {
            return null;
        }

        ListNode curr = head;

        while (curr != null) {
            if (nodeMap.get(curr) != null) {
                return nodeMap.get(curr);
            }
            nodeMap.put(curr, curr);
            curr = curr.next;
        }

        return null;
    }
}
