package 字符串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// todo 动态规划的解法
// https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
public class L022 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0) return res;

        dfs("", n, n, res);
        return res;
    }

    /**
     * 深度优先搜索
     * @param curStr： 当前拼接的括号字符串
     * @param left：剩余可用的左括号数量
     * @param right：剩余可用的右括号数量
     * @param res： 用于存放有效括号组合
     */
    private static void dfs(String curStr, Integer left, Integer right, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 当剩余可用左括号的数量大于剩余可用右括号的数量时
        // 此时剪枝，因为此时不是有效括号
        if (left > right) return;

        if (left > 0) dfs(curStr + "(", left-1, right, res);

        if (right > 0) dfs(curStr + ")", left, right-1, res);
    }

    /**
     * 广度优先的解题思路
     */
    public static List<String> generateParenthesisBFS(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(new Node("", n, n));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            if (node.left == 0 && node.right == 0) {
                res.add(node.curStr);
                continue;
            }

            if (node.left > node.right) continue;

            if (node.left > 0 ) nodes.offer(new Node(node.curStr + "(", node.left-1, node.right));

            if (node.right > 0 )  nodes.offer(new Node(node.curStr + ")", node.left, node.right-1));
        }

        return res;
    }

    static class Node {
        private String curStr;
        private Integer left;
        private Integer right;

        public Node(String curStr, Integer left, Integer right) {
            this.curStr = curStr;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesisBFS(3));
    }
}
