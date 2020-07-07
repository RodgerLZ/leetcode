package 栈;

import java.util.Stack;

/**
 * 682. 棒球比赛
 */
public class L0682 {
    public int calPoints(String[] ops) {

        int res = 0;
        if (ops == null || ops.length == 0) return res;

        Stack<Integer> stack = new Stack<>();

        for (String s:ops) {
            int currentSoc;
            switch (s) {
                case "C":
                    currentSoc = stack.pop();
                    res -= currentSoc;
                    break;
                case "D":
                    currentSoc = stack.peek() * 2;
                    res += currentSoc;
                    stack.push(currentSoc);
                    break;
                case "+":
                    int s1 = stack.pop();
                    int s2 = stack.peek();
                    currentSoc = s1+s2;
                    res += currentSoc;
                    stack.push(s1);
                    stack.push(currentSoc);
                    break;
                default:
                    currentSoc = Integer.parseInt(s);
                    res += currentSoc;
                    stack.push(currentSoc);
                    break;
            }
        }

        return res;
    }
}
