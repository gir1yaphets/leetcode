package tree.first;

import tree.TreeNode;

public class LC98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        if (min != null && val <= min) {
            return false;
        }

        if (max != null && val >= max) {
            return false;
        }

        if (!helper(node.left, min, val)) return false;
        if (!helper(node.right, val, max)) return false;

        return true;
    }
}
