package 栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class L0144 {
    /**
     * 通过递归的算法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);
        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }

        return res;
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() != 0) {
            TreeNode currentNode = stack.pop();

            res.add(currentNode.val);

            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }

        return res;
    }
}
