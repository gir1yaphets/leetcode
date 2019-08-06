package tree.first;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class LC872LeafSimilarTrees {
    //https://leetcode.com/problems/leaf-similar-trees/discuss/330986/Java-solution
    List<Integer> leafList1 = new ArrayList<>();
    List<Integer> leafList2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        addNode(root1, leafList1);
        addNode(root2, leafList2);

        if (leafList1.size() != leafList2.size()) {
            return false;
        }

        for (int i = 0; i < leafList1.size(); i++) {
            if (leafList1.get(i) != leafList2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void addNode(TreeNode node, List<Integer> leafList) {
        if (node.left == null && node.right == null) {
            leafList.add(node.val);
            return;
        }

        if (node.left != null) {
            addNode(node.left, leafList);
        }

        if (node.right != null) {
            addNode(node.right, leafList);
        }

    }
}
