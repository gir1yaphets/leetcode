package tree.first;

import tree.TreeNode;

public class LC543DiameterOfBinaryTree {
    int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        ans = Math.max(ans, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
