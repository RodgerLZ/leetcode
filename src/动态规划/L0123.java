package 动态规划;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class L0123 {
    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) return 0;

        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i=1; i<len; i++) {
            for (int j=2; j>=1; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);
            }
        }

        return dp[len-1][2][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
