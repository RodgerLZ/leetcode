package 动态规划;

import java.util.Arrays;

/**
 * 64. 最小路径和
 */
public class L0064 {
    public static int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;

        int w = grid[0].length;
        int[] dp = new int[w];
        Arrays.fill(dp, 1, w, Integer.MAX_VALUE);

        for (int[] ints:grid) {
            for (int j = 0; j < w; j++) {

                if (j == 0) dp[j] += ints[0];
                else dp[j] = Math.min(dp[j], dp[j - 1]) + ints[j];
            }
        }

        return dp[w-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
