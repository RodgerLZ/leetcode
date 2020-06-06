package 动态规划;

/**
 * 53. 最大子序和
 */
public class L0053 {
    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i<nums.length; i++) {
            dp[i] = nums[i] + Math.max(0, dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
