package 动态规划;

/**
 * 518. 零钱兑换 II
 */
public class L0518 {
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 注意与377题的区别
        // 这里要注意与爬楼梯问题区分
        // 当前这种循环求出来的是组合数
        // 更换循环顺序之后，求出的为排列数，即（1，2）（2，1）算两种
        for (int coin:coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
    }
}
