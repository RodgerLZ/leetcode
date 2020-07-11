package 栈;

import java.util.Stack;

/**
 * 739. 每日温度
 */
public class L0739 {
    public int[] dailyTemperatures(int[] T) {

        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< len; i++) {

            while (!stack.isEmpty()) {
                Integer index = stack.peek();
                if (T[index] >= T[i]) {
                    stack.push(i);
                    break;
                } else {
                    res[stack.pop()] = i-index;
                }
            }

            if (stack.isEmpty()) {
                stack.push(i);
            }
        }

        return res;

    }
}
