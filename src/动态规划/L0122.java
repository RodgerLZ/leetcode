package 动态规划;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class L0122 {
    // 贪心算法
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len <2) return 0;
        int res = 0;
        int pre = prices[0];

        for (int i = 1; i< len; i++) {
            if (prices[i]>pre) res += prices[i] - pre;

            pre = prices[i];
        }

        return res;

    }
}
