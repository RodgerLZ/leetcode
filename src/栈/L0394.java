package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)
 */
public class L0394 {

    // 思路是通过一个双端队列完成的
    // 另一个思路是通过两个栈（双端队列），其中一个队列用于存储string，另个一用于存储解码得到的数字。
    public static String decodeString(String s) {

        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();

        for (char c: chars) {
            if (c == ']') {
                decodeString(deque);
            } else {
                deque.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }

    private static void decodeString(Deque<Character> deque) {

        Deque<Character> newDe = new LinkedList<>();

        while (true) {
            Character aChar = deque.removeLast();
            if (aChar == '[') {
                int count = getCount(deque);

                while (count-->0) {
                    deque.addAll(newDe);
                }

                break;
            } else {
                newDe.addFirst(aChar);
            }
        }
    }

    private static int getCount(Deque<Character> deque) {
         int res = 0;
         int n = 0;

         while (!deque.isEmpty() && Character.isDigit(deque.peekLast())){
             res += Math.pow(10, n++) * (deque.removeLast() - '0');
         }

         return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]12[bc]"));
    }
}
