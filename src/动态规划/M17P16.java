package 动态规划;

/**
 * 面试题 17.16. 按摩师
 */
public class M17P16 {
    public static int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        ints[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            ints[i] = Math.max(ints[i-2]+nums[i], ints[i-1]);
        }

        return ints[nums.length-1];
    }

    /**
     * 这里和上面的解法思想一致，将空间从o(n)优化到o(1)
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
     */

    public static void main(String[] args) {
        System.out.println(massage(new int[]{1,2,3,1}));
        System.out.println(massage(new int[]{2,7,9,3,1}));
        System.out.println(massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
