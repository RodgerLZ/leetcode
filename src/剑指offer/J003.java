package 剑指offer;

import java.util.HashSet;

/**
 * 面试题03. 数组中重复的数字
 */
public class J003 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int n:nums) {
            if (!integers.add(n)) return n;
        }

        return -1;
    }
}
