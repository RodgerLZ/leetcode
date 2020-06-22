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


    // 动态规划
    // 这题更适合用贪心算法，动态规划只为了掌握方法。
    public int maxProfitDp(int[] prices) {

        int len = prices.length;
        if(len<2) return 0;

        int cash = 0;
        int stock = -prices[0];
        int preCash;
        int preStock;

        for (int i=1; i<len; i++) {
            preCash = cash;
            preStock = stock;
            cash = Math.max(preCash, preStock + prices[i]);
            stock = Math.max(preCash - prices[i], preStock);
        }

        return cash;
    }
}
