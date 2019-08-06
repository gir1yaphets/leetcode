package tree.second;

import tree.TreeNode;

public class LC111 {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.right == null) {
            return getMinDepth(node.left) + 1;
        }

        if (node.left == null) {
            return getMinDepth(node.right) + 1;
        }

        return Math.min(getMinDepth(node.left), getMinDepth(node.right)) + 1;
    }

    /**
     * 错误做法
     * 错误原因：没有考虑单边的二叉树
     * @param node
     * @return
     */
    private int getMinDepthError(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return Math.min(getMinDepth(node.left), getMinDepth(node.right)) + 1;
    }
}
