package 栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class L0496 {

    /**
     * 单调栈的解法
     */
    public static int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int value : nums2) {

            while (!stack.isEmpty()) {
                if (value <= stack.peek()) {
                    stack.push(value);
                    break;
                } else {
                    map.put(stack.pop(), value);
                }
            }

            if (stack.isEmpty()) {
                stack.push(value);
            }
        }

        while (!stack.isEmpty()) map.put(stack.pop(), -1);

        for (int i=0; i<nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    /**
     * 暴力解法
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i=0; i<nums1.length; i++) {
            res[i] = -1;
            for (int j=0; j<nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    for (j = j+1; j<nums2.length; j++) {
                        if (nums1[i] < nums2[j]) {
                            res[i] = j;
                            j = nums2.length;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElementStack(nums1, nums2)));
    }
}
