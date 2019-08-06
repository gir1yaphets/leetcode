package tree.second;

import tree.TreeNode;

public class LC897 {
    public TreeNode increasingBST(TreeNode root) {
        return (root);
    }

    public void helper(TreeNode node, TreeNode prev) {
        if (node == null) {
            return;
        }

        helper(node.left, node);

        if (node.right != null) {
            node.right.right = prev;
        } else {
            node.right = prev;
        }
    }
}
