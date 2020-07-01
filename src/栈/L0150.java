package 栈;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 */
public class L0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        Integer op1, op2;

        for (String token:tokens) {
            switch (token) {
                case "+":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 + op2);
                    break;
                case "-":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 - op2);
                    break;
                case "*":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 * op2);
                    break;
                case "/":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1 / op2);
                    break;
                default:
                    s.push(Integer.parseInt(token));
                    break;
            }
        }

        return s.pop();
    }
}
