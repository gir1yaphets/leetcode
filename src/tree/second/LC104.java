package tree.second;

import tree.TreeNode;

public class LC104 {
    public int maxDepth(TreeNode root) {
        //递归左子树和右子树的最大高度 加根节点的一层
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
