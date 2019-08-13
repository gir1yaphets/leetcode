package tree.second.lv1;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new LinkedList<>();
        List<Integer> leaf2 = new LinkedList<>();

        addLeaf(root1, leaf1);
        addLeaf(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    private void addLeaf(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        }

        addLeaf(root.left, leafList);
        addLeaf(root.right, leafList);
    }
}
