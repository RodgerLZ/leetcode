package 动态规划;

/**
 * 63. 不同路径 II
 */
public class L0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length==0
                || obstacleGrid[0].length==0
                || obstacleGrid[0][0] == 1) return 0;

        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) dp[j] = 0;
                else if (j != 0) dp[j] += dp[j - 1];
            }
        }

        return dp[n-1];
    }
}
