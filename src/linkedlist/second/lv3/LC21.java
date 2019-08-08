package linkedlist.second.lv3;

import linkedlist.ListNode;

public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return helper(l1, l2);
    }

    /**
     * 错误做法：需求没看清，并不是交叉merge，而是需要sorted merge
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 错误做法
     * @param l1
     * @param l2
     * @return
     */
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
            if (max != null) {
                ListNode nextMax = max.next;
                if (min.next != null && min.next.val > max.val) {
                    min.next = max;
                    min.next.next = nextMin;
                    max = nextMax;
                }
            }
            prev = min;
            min = nextMin;
        }

        if (max != null) {
            prev.next = max;
        }

        return dummy.next;
    }

    /**
     * 开一个新节点result，然后遍历l1,l2, 新节点的next每次都指向curr1,curr2中小的那个，指向哪个，哪个就向前移动一位
     * @param l1
     * @param l2
     * @return
     */
    private ListNode helper3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode(-1);

        ListNode curr1 = l1, curr2 = l2, curr = res;
        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                curr.next = curr2;
                return res.next;
            }

            if (curr2 == null) {
                curr.next = curr1;
                return res.next;
            }

            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        return res.next;
    }

    private ListNode helper3Better(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode(-1);

        ListNode curr1 = l1, curr2 = l2, curr = res;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        curr.next = curr1 == null ? curr2 : curr1; //放到循环里判断同样会耗时

        return res.next;
    }

    private ListNode helperRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = helperRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = helperRecursion(l1, l2.next);
            return l2;
        }
    }
}
