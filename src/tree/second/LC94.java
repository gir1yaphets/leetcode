package tree.second;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    private List<Integer> iteratorHelper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();

        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}
