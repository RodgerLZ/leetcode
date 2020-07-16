package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * [321. 拼接最大数](https://leetcode-cn.com/problems/create-maximum-number/)
 */
public class L0321 {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[k];
        int min = Math.max(0, k - len2);
        int max = Math.min(len1, k);
        for (int i = min; i <= max; i++) {
            int[] sub1 = subMaxNumber(nums1, i);
            int[] sub2 = subMaxNumber(nums2, k - i);
            int[] merge = merge(sub1, sub2);

            if (compare(merge, res)) res = merge;
        }

        return res;
    }

    private static int[] subMaxNumber(int[] nums, int k) {

        int popCount = nums.length - k;
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {

            while (!stack.isEmpty() && popCount > 0) {
                Integer pre = stack.peek();
                if (pre < num) {
                    stack.pop();
                    popCount--;
                } else {
                    break;
                }
            }

            stack.push(num);
        }

        while (popCount-- > 0) stack.pop();

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = stack.pop();

        return res;
    }

    // 注意：
    // 在合并的时候，如果遇到数字相同的时候，需要比较剩余子串的大小，去较大的子串的首字
    private static int[] merge(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1 + len2];

        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            int num1 = i < len1 ? nums1[i] : -1;
            int num2 = j < len2 ? nums2[j] : -1;

            if (num1 < num2) {
                res[i + j] = num2;
                j++;
            } else if (num1 > num2) {
                res[i + j] = num1;
                i++;
            } else if (compare(Arrays.copyOfRange(nums1, i, len1), Arrays.copyOfRange(nums2, j, len2))) {
                res[i + j] = num1;
                i++;
            }  else {
                res[i + j] = num2;
                j++;
            }
        }

        return res;
    }

    private static boolean compare(int[] nums1, int[] nums2) {
        int n = Math.min(nums1.length, nums2.length);

        for (int i = 0; i < n; i++) {
            if (nums1[i] > nums2[i]) return true;
            else if (nums1[i] < nums2[i]) return false;
        }

        return nums1.length > nums2.length;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        System.out.println(Arrays.toString(maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(maxNumber(new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15)));
        System.out.println(Arrays.toString(maxNumber(new int[]{8,5,9,5,1,6,9}, new int[]{2,6,4,3,8,4,1,0,7,2,9,2,8}, 20)));
    }
}