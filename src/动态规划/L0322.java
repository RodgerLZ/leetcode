package 动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换 (完全背包)
 */
public class L0322 {
    public static int coinChange(int[] coins, int amount) {

        int length = coins.length;
        if (length == 0) return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, amount+1, Integer.MAX_VALUE);

        for (int i:coins) {
            for (int j=i; j<=amount; j++) {
                if (dp[j-i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-i] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE? -1:dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
}
