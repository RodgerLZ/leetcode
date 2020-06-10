package 动态规划;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class L0354 {
    public int maxEnvelopes(int[][] envelopes) {

        // 先按照 w 升序排列；当 w 相同时，按照 h 降序排列。
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] ints = new int[envelopes.length];
        for (int i=0; i<envelopes.length; i++) {
            ints[i] = envelopes[i][1];
        }

        // 对排序后的 h，求最长上升子序列的长度。
        return lengthOfLIS(ints);
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) return 1;

        int length = nums.length;
        int[] dp = new int[length];

        int res = 0;
        for(int i = 0; i< length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
