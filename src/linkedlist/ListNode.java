package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode getMockListNode() {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
//        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
//        node3.next = node4;

        return node0;
    }

    public static ListNode array2ListNode(int[] array) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        for (int i = 0; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }

        return res.next;
    }
}
