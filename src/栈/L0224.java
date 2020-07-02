package 栈;

import java.util.Stack;

/**
 * 224. 基本计算器
 */
public class L0224 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char[] chars = s.toCharArray();
        int res = 0;
        int sign = 1;

        for (int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i+1 < chars.length && Character.isDigit(chars[i+1])) {
                    cur = cur*10 + chars[++i] - '0';
                }
                res += cur * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')'){
                res = stack.pop() * res + stack.pop();
            }
        }

        return res;
    }
}
