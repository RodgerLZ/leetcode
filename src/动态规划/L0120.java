package 动态规划;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class L0120 {

    /**
     * 解题思路：动态规划，由底向上求解
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.isEmpty()) return 0;

        int m = triangle.size();

        // 最简单的解法是二维的dp数组
        // 为了节省内存，进一步优化为一维数组
        int[] dp = new int[m];

        for (int i=m-1; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                if (i==m-1) {
                    dp[j] = triangle.get(i).get(j);
                    continue;
                }

                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }

        return dp[0];
    }
}
