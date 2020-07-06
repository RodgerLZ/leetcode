package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 */
public class L0145 {

    /**
     * 通过迭代的方式
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left != null) res.addAll(postorderTraversal(root.left));
        if (root.right != null) res.addAll(postorderTraversal(root.right));
        res.add(root.val);

        return res;
    }

    /**
     * 通过栈的方式
     */
    public static List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<List<Object>> stack = new Stack<>();
        stack.push(Arrays.asList(0, root));

        while (stack.size() != 0) {
            List<Object> item = stack.pop();
            int flag = (Integer) item.get(0);
            TreeNode curr = (TreeNode) item.get(1);

            if (flag == 1) {
                res.add(curr.val);
            } else {
                stack.push(Arrays.asList(1, curr));
                if (curr.right != null) stack.push(Arrays.asList(0, curr.right));
                if (curr.left != null) stack.push(Arrays.asList(0, curr.left));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node2.right = node3;

        System.out.println(postorderTraversalStack(node1));
    }

}
