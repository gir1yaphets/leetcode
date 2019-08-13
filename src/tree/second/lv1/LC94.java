package tree.second.lv1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return heler1(root);
    }

    /**
     * Recursive solution
     * @param root
     * @return
     */
    private List<Integer> heler1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    /**
     * Iterator solution
     * @param root
     * @return
     */
    private List<Integer> helper2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        TreeNode curr = root;

        while (curr !=  null || !stack.isEmpty()) {
            //1.move to the leftmost node, and push each node before it to the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //2.pop the node from stack and search right for each node
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}
