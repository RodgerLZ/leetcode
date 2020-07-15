package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [402. 移掉K位数字](https://leetcode-cn.com/problems/remove-k-digits/)
 */
public class L0402 {
    public static String removeKdigits(String num, int k) {

        int len = num.length();
        if (len == k) return "0";

        char[] chars = num.toCharArray();
        Deque<Integer> deque = new LinkedList<>();

        for (char aChar: chars) {
            int curr = aChar - '0';
            while (!deque.isEmpty() && curr < deque.peekLast() && k>0) {
                deque.removeLast();
                k--;
            }

            deque.addLast(curr);
        }

        while (k>0) {
            deque.removeLast();
            k--;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Integer each = deque.removeFirst();
            if (flag) {
                sb.append(each);
            } else {
                if (!each.equals(0)) {
                    flag = true;
                    sb.append(each);
                }
            }
        }

        return flag ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 1));
        System.out.println(removeKdigits("113", 1));
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("1234567890", 9));
    }
}
