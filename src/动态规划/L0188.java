package 动态规划;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class L0188 {
    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len<2 || k==0) return 0;

        // 如果k >= len/2，相当于不限制交易次数
        if (k >= len/2) return maxProfit(prices);

        // 状态压缩，从三维dp压缩到二维dp
        int[][] dp = new int[k + 1][2];

        // 初始化第一天的状态
        // 交易次数为0时，持有股票的状态。不可能发生，所有这里是MIN_VALUE
        dp[0][1] = Integer.MIN_VALUE;
        for(int j=1; j<k+1; j++) {
            // 当交易次数 >= 1时，持有股票的状态，为
            dp[j][1] = -prices[0];
        }

        // 第一天的状态已经在之前初始化成功，所以这里从第二天开始循环。
        for (int i=1; i<len; i++) {
            for (int j=0; j<k+1; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                if (j!=0) {
                    dp[j][1] = Math.max(dp[j-1][0] - prices[i], dp[j][1]);
                }
            }
        }

        return dp[k][0];
    }

    private static int maxProfit(int[] prices) {
        int res = 0;
        int prePri = prices[0];

        for (int i=1; i<prices.length; i++) {
            if (prePri<prices[i]) res += prices[i] - prePri;
            prePri = prices[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(1, new int[]{3,2,6,5,0,3}));
    }
}
