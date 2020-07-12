package 栈;

import java.util.Stack;

/**
 * 556. 下一个更大元素 III
 */
public class L0556 {

    public static int nextGreaterElement(int n) {

        if (n <= 11) return -1;

        int res = 0;
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(chars.length-1);

        for (int i=chars.length-2; i>=0; i--) {

            int index = -1;

            while (!stack.isEmpty()) {
                if (chars[i] >= chars[stack.peek()]) {
                    stack.push(i);
                    break;
                } else {
                    index = stack.pop();
                }
            }

            if (index != -1) {
                char tmp = chars[index];
                chars[index] = chars[i];
                chars[i] = tmp;

                for (char aChar : chars) {
                    res = res * 10 + (aChar - '0');
                }

                return res;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(5643));
    }
}
