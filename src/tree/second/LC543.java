package tree.second;

import tree.TreeNode;

public class LC543 {
    private int point = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return point - 1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftH = helper(node.left);
        int rightH = helper(node.right);

        //对于每一个node都统计一次左到右的最长路径
        point = Math.max(point, leftH + rightH + 1);

        return Math.max(leftH, rightH) + 1;
    }


    /**
     * 错误原因：题目中说的是任意两个两个节点之间的最长路径，并不一定要经过root节点，所以不能用左子树高度+右子树高度计算
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeError(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        return leftH + rightH;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
