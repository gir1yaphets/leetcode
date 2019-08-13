package tree.second.lv1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class LC114 {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();

        helper2(root, nodes);
        TreeNode curr = root;
        for (int i = 1; i < nodes.size(); i++) {
            curr.right = new TreeNode(nodes.get(i));
            curr.left = null;
            curr = curr.right;
        }
    }

    private void helper1(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }

        curr = root;
        for (int i = 1; i < list.size(); i++) {
            curr.right = new TreeNode(list.get(i));
            curr.left = null;
            curr = curr.right;
        }
    }

    private void helper2(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        helper2(root.left, nodes);
        helper2(root.right, nodes);
    }

    /**
     * 1.将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边节点
     * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @param root
     */
    public void helper3(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    /**
     * 用后序遍历得到每一个node，然后存住前一个node，往前指
     * @param root
     */
    public void helper4(TreeNode root) {
        if (root == null)
            return;
        helper4(root.right);
        helper4(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
