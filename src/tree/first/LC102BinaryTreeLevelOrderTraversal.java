package tree.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LC102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    private List<List<Integer>> levelOrderWithBFS(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLine = new LinkedList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    currentLine.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            result.add(currentLine);
        }

        return result;
    }

    private List<List<Integer>> levelOrderWithDFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(0, root, result);

        return result;
    }

    private void helper(int level, TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        List<Integer> currentLine;
        if (level >= result.size()) {
            currentLine = new LinkedList<>();
            result.add(level, currentLine);
        } else {
            currentLine = result.get(level);
        }

        currentLine.add(node.val);

        helper(level + 1, node.left, result);
        helper(level + 1, node.right, result);
    }
}
