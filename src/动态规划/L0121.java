package 动态规划;

public class L0121 {
    /**
     * 暴力解法
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int maxP = 0;
        for (int i=0; i<prices.length; i++) {
            int a = 0;
            for (int j=i+1; j<prices.length; j++) {
                int b = a - prices[j-1] + prices[j];
                a = b;
                maxP = Math.max(b, maxP);
            }
        }

        return maxP;
    }

    /**
     * 暴力的方式，时间复杂度为o(n^2)
     * 这个方法通过一次遍历的方式得出解
     */
    public static int maxProfitWeb(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitWeb(new int[]{2,1,3,4,1,2,1,5,4}));
        System.out.println(maxProfitWeb(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitWeb(new int[]{7,6,4,3,1}));
    }
}
