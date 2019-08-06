package tree.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LC104MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);


        return Math.max(left, right) + 1;
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> currentLine = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    currentLine.add(node.val);

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            result.add(currentLine);
        }

        return result.size();
    }
}
