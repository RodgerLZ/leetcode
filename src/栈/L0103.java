package 栈;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
public class L0103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        List<Integer> eachRes = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                eachRes.add(curr.val);

                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }

            if (!eachRes.isEmpty()) {
                res.add(eachRes);
                eachRes = new ArrayList<>();
            }

            while (!s2.isEmpty()) {
                TreeNode curr = s2.pop();
                eachRes.add(curr.val);

                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }

            if (!eachRes.isEmpty()) {
                res.add(eachRes);
                eachRes = new ArrayList<>();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n2.left = n4;
        n3.right = n5;
        n1.left = n2;
        n1.right = n3;

        System.out.println(zigzagLevelOrder(n1));
    }
}
