package linkedlist.first;

import linkedlist.ListNode;

public class LC143ReorderList {
    public void reorderList(ListNode head) {
        ListNode middle = head;
        ListNode fast = head;

//        while (fast != null && fast.next != null) {
//            middle = middle.next;
//            fast = fast.next.next;
//        }

        while (fast.next != null && fast.next.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

//        ListNode second = reverseList(slow.next);
//
//        ListNode p1 = head;
//        ListNode p2 = second;
//
//        while (p1 != p2 && p2 != null) {
//            ListNode nextNode1 = p1.next;
//            ListNode nextNode2 = p2.next;
//
//            p1.next = p2;
//            p1.next.next = nextNode1;
//
//            p1 = nextNode1;
//            p2 = nextNode2;
//
////            p2.next = nextNode1; //***error, change the list node to ring
////            p1.next = p2;
////            p1 = nextNode1;
////            p2 = nextNode2;
//        }

        ListNode prev = middle;
        ListNode curr = middle.next;

//        while (curr != null) {
//            ListNode tempNext = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = tempNext;
//        }
//        middle.next = prev;

        while (curr.next != null) {
            ListNode tempNext = curr.next;
            curr.next = curr.next.next;
            tempNext.next = prev.next;
            prev.next = tempNext;
        }

        ListNode p1 = head;
        ListNode p2 = middle.next;

        while (p1 != middle) {
            middle.next = p2.next;
//            ListNode tempNext1 = p1.next;
//            p1.next = p2;
//            p2.next = tempNext1;

            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
            p2 = middle.next;
        }
    }

    public void reorderListAnswer(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
