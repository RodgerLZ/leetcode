package 栈;

import java.util.*;

/**
 * 556. 下一个更大元素 III
 */
public class L0556 {

    public static int nextGreaterElement(int n) {

        if (n <= 11) return -1;

        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;

        for (int i = len-2; i>=0; i--) {
            if (chars[i] < chars[i+1]) {

                int j = i+1;
                while (j<=len-2 && chars[i] < chars[j+1]) j++;
                swap(chars, i, j);

                reverse(chars, i+1, len-1);

                try {
                    return Integer.parseInt(new String(chars));
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }

        return -1;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start<end) {
            swap(chars, start++, end--);
        }
    }

    // 没有考虑溢出情况
    public static int nextGreaterElementError(int n) {

        if (n <= 11) return -1;

        int res = 0;
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        LinkedList<Integer> list = new LinkedList<>();
        list.add(chars.length-1);

        for (int i=chars.length-2; i>=0; i--) {

            int index = -1;

            if (chars[i] >= chars[list.getLast()]) {
                list.addLast(i);
            } else {
                int len = list.size() - 2;

                while (len>=0 && chars[i] < chars[list.get(len)]) len--;

                index = list.get(len+1);
            }

            if (index != -1) {
                char tmp = chars[index];
                chars[index] = chars[i];
                chars[i] = tmp;

                for (int j=0; j<=i; j++) {
                    res = res * 10 + (chars[j] - '0');
                }

                while (!list.isEmpty()) {
                    res = res * 10 + chars[list.removeFirst()] - '0';
                }

                return res;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(nextGreaterElement(26431));
        System.out.println(nextGreaterElement(12443322));
        System.out.println(nextGreaterElement(5643));
    }
}
