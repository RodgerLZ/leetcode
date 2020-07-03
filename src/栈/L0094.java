package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 */
public class L0094 {

    /**
     * 通过栈的方式
     */
    public static List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        stack.push(root);
        TreeNode curr = root.left;

        while (!stack.isEmpty() || curr!=null) {

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

    public static List<Integer> inorderTraversal01(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<List<Object>> stack = new Stack<>();
        // 0 表示节点尚未访问过
        // 1 表示节点已经访问过
        stack.push(Arrays.asList(0, root));

        while (!stack.isEmpty()) {
            List<Object> item = stack.pop();

            if (item.get(1) == null) continue;
            TreeNode treeNode = (TreeNode) item.get(1);

            if ((int) item.get(0) == 0) {
                stack.push(Arrays.asList(0, treeNode.right));
                stack.push(Arrays.asList(1, treeNode));
                stack.push(Arrays.asList(0, treeNode.left));
            } else {
                res.add(treeNode.val);
            }
        }

        return res;
    }

    /**
     * 递归的方式
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left != null) {
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if (root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node2.right = node3;

        System.out.println(inorderTraversal01(node1));
    }
}
