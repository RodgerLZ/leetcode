package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 */
public class L0503 {

    /**
     * 一次循环
     * 代码简洁，但是实际运行效率没有下面两次循环高
     */
    public static int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i < nums.length*2-1; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (nums[i % nums.length] <= nums[index]) {
                    stack.push(i % nums.length);
                    break;
                } else {
                    res[stack.pop()] = nums[i % nums.length];
                }
            }

            if (stack.isEmpty()) {
                stack.push(i % nums.length);
            }
        }

        return res;
    }

    /**
     * 两次循环
     * 第一次循环得到单调栈
     * 栈内存储的是索引而不是具体的值
     */
    public static int[] nextGreaterElementsSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nums.length; i++) {

            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (nums[i] <= nums[index]) {
                    stack.push(i);
                    break;
                } else {
                    res[stack.pop()] = nums[i];
                }
            }

            if (stack.isEmpty()) {
                stack.push(i);
            }
        }

        for (int i=0; i<nums.length-1; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (nums[i] > nums[index]) {
                    res[stack.pop()] = nums[i];
                } else break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElementsSelf(new int[]{1, 2, 1})));
    }
}
