package 动态规划;

/**
 * 55. 跳跃游戏
 */
public class L0055 {

    // 动态规划的解法，但是效率在这题中不是最好的。
    public boolean canJump(int[] nums) {

        int len = nums.length;

        if (len ==0) return false;

        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 0; i< len; i++) {
            if(dp[i]) {
                int stepNum = nums[i];
                for (int j=0; j<=stepNum; j++) {
                    if(i+j< len) dp[i+j] = true;

                    if ((i+j)== len -1) return true;
                }
            }
        }

        return dp[len-1];
    }
}
