package tree.first;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class LC897IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        TreeNode result = new TreeNode(list.get(0));
        TreeNode curr = result;
        for (int i = 1; i < list.size(); i++) {
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }

        return result;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            helper(node.left, list);

            list.add(node.val);

            helper(node.right, list);
        }
    }


    //others solution
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
