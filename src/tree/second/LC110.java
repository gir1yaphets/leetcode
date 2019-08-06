package tree.second;

import tree.TreeNode;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftH = helper(node.left);

        int rightH = helper(node.right);

        if (Math.abs(rightH - leftH) > 1) {
            return -1;
        }

        //如果某一子树中出现了-1，就不要继续走下面的return计算高度了，直接把-1一直return回去
        if (leftH == -1 || rightH == -1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }


    /**
     * 错误做法
     * 错误原因：单边二叉树最大高度最小高度一样，最大-最小=0,但不是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalancedError(TreeNode root) {
        return (getMaxDepth(root) - getMinDepth(root)) <= 1;
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

    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }
}
