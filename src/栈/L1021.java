package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [1021. 删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/)
 */
public class L1021 {
    public static String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();

        char[] chars = S.toCharArray();
        for (char c:chars) {
            if (deque.size() == 0) {
                deque.addLast(c);
                continue;
            }

            if (c == ')') {
                deque.removeLast();
                if (deque.size() != 0) {
                    sb.append(c);
                }
                continue;
            }

            deque.addLast(c);
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses(""));
    }
}
