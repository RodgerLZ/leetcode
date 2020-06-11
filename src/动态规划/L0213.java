package 动态规划;

/**
 * 213. 打家劫舍 II
 */
public class L0213 {
    // 思路在于将环形问题分解成两个单排问题
    // 分别求解 0--length-1 以及 1--length 的最优解
    // 然后取最大值则为该题的解
    public int rob(int[] nums) {

        int length = nums.length;

        if (length==1) return nums[0];

        return Math.max(rob(nums, 0, length-1), rob(nums, 1, length));

    }

    public int rob(int[] nums, int l, int r) {
        int a=0,b=0,c=0;
        for(int i=l; i<r; i++) {
            c = Math.max(nums[i]+a, b);
            a = b;
            b = c;
        }

        return c;
    }
}
