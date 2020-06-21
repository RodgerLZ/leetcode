package 动态规划;

/**
 * 377. 组合总和 Ⅳ
 */
public class L0377 {

    // todo 如果顺序不同的序列视为相同的组合，这题需要怎么解。为什么？
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 这里注意与518题的区别
        for (int i=1; i<=target; i++) {
            for (int num:nums) {
                dp[i] += (i>=num)? dp[i-num]:0;
            }
        }

        return dp[target];
    }
}
