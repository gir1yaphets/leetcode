package tree.second;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new LinkedList<>();
        List<Integer> res2 = new LinkedList<>();

        dfsHelper(root1, res1);
        dfsHelper(root2, res2);

        if (res1.size() != res2.size()) {
            return false;
        }

        for (int i = 0; i < res1.size(); i++) {
            if (res1.get(i) != res2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void dfsHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        dfsHelper(node.left, res);

        dfsHelper(node.right, res);

        if (node.left == null && node.right == null) {
            res.add(node.val);
        }
    }

    /**
     * 错误原因：如果中间的节点深度比两边大，那么中间的叶子节点则加在list最后面，导致顺序不一致
     * 所以bfs的方法不太好解
     * @param root
     * @return
     */
    private List<Integer> bfsHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new LinkedList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    result.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
