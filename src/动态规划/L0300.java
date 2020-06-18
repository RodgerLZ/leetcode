package 动态规划;

/**
 * 300. 最长上升子序列
 */
public class L0300 {
    // todo 时间复杂度o(nlogn)的解法
    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;

        int res = 1;
        // dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1; i<=nums.length-1; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

                dp[i] = Math.max(dp[i], 1);
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{-2, -1}));
    }
}
