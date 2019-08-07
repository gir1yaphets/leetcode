import java.util.List;

import linkedlist.ListNode;
import linkedlist.second.lv1.LC234;
import linkedlist.second.lv2.LC143;
import linkedlist.second.lv2.LC24;
import linkedlist.second.lv3.LC142;
import searchandsort.LC324;
import searchandsort.LC969;
import tree.TreeNode;
import tree.first.LC897IncreasingOrderSearchTree;
import tree.second.LC110;
import tree.second.LC872;

public class Main {

    public static void main(String[] args) {
        test969();
        test324();
        test110();
        test872();
        test897();
        test234();
        test24();
        test143();
        test142();
    }

    private static void test969() {
        List<Integer> result = new LC969().pancakeSort(new int[]{3, 2, 4, 1});
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void test324() {
        int[] nums = new int[] {1,5,1,1,6,4};
        new LC324().wiggleSort(nums);
    }

    private static void test110() {
        new LC110().isBalanced(TreeNode.getMockTree2());
    }

    private static void test872() {
        new LC872().leafSimilar(TreeNode.getMockTree3(), TreeNode.getMockTree4());
    }

    private static void test897() {
//        new LC897().helper(TreeNode.getMockTree(), null);
        new LC897IncreasingOrderSearchTree().increasingBST(TreeNode.getMockTree(), null);
    }

    private static void test234() {
        new LC234().helper(ListNode.getMockListNode());
    }

    private static void test24() {
        new LC24().swapPairs(ListNode.getMockListNode());
    }

    private static void test143() {
        new LC143().reorderList(ListNode.getMockListNode());
    }

    private static void test142() {
        new LC142().detectCycle(ListNode.getMockListNode());
    }
}
