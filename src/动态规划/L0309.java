package 动态规划;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class L0309 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2) return 0;

        int dp_im1_0 = 0;
        int dp_im1_1 = -prices[0];
        int dp_im2_0 = 0;
        int dp_i_0 = 0;

        for (int i=1; i<len; i++) {
            dp_i_0 = Math.max(dp_im1_0, dp_im1_1 + prices[i]);
            int dp_i_1 = Math.max(dp_im1_1, dp_im2_0 - prices[i]);

            dp_im2_0 = dp_im1_0;
            dp_im1_0 = dp_i_0;
            dp_im1_1 = dp_i_1;
        }

        return dp_i_0;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,4}));
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
