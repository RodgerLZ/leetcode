package 动态规划;

/**
 * 416. 分割等和子集（背包问题）
 */
public class L0416 {
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        // 和为奇数
        if ((sum & 1) == 1) return false;

        int length = nums.length;
        int target = sum / 2;

        if (nums[0] == target) return true;

        boolean[][] dp = new boolean[length][target+1];

        dp[0][0] = true;
        if (nums[0] < target) dp[0][nums[0]] = true;

        for (int i=1; i<length; i++) {
            for (int j=0; j<=target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    continue;
                }

                dp[i][j] = dp[i-1][j];
            }

            if (dp[i][target]) return true;
        }

        return dp[length-1][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,5}));
    }
}
