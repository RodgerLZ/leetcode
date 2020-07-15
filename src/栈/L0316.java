package 栈;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/)
 */
public class L0316 {
    public static String removeDuplicateLetters(String s) {

        if (s.isEmpty()) return s;

        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        // 计数，记录每个char出现的次数
        for (char aChar:chars) counts[aChar - 'a']++;

        // 双端队列，用来存储char
        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for (char aChar:chars) {
            counts[aChar - 'a']--;
            if (!set.contains(aChar)) {
                while (!deque.isEmpty()) {
                    char pre = deque.peekLast();
                    if (pre > aChar && counts[pre - 'a'] > 0) {
                        set.remove(deque.removeLast());
                    } else {
                        break;
                    }
                }

                deque.addLast(aChar);
                set.add(aChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.removeFirst());

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
