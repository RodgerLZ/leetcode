package 动态规划;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class L0714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;

        int dp_im1_0 = 0;
        int dp_im1_1 = -prices[0];
        int dp_i_0 = 0;

        for (int i=1; i<len; i++) {
            dp_i_0 = Math.max(dp_im1_0, dp_im1_1 + prices[i] - fee);
            int dp_i_1 = Math.max(dp_im1_0 - prices[i], dp_im1_1);

            dp_im1_0 = dp_i_0;
            dp_im1_1 = dp_i_1;
        }

        return dp_i_0;
    }
}
