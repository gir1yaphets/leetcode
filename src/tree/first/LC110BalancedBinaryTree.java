package tree.first;

import tree.TreeNode;

public class LC110BalancedBinaryTree {
    //https://leetcode.com/problems/balanced-binary-tree/discuss/330223/Java-solution
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftH = getHeight(node.left);
        if (leftH == -1) {
            return -1;
        }

        int rightH = getHeight(node.right);
        if (rightH == -1) {
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);

        return Math.max(left, right) + 1;
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null) {
            return 1 + getMinDepth(node.right);
        }

        if (node.right == null) {
            return 1 + getMinDepth(node.left);
        }

        return 1 + Math.min(getMinDepth(node.left), getMinDepth(node.right));
    }
}
