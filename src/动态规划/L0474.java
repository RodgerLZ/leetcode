package 动态规划;

/**
 * 474. 一和零 (二维费用背包)
 */
public class L0474 {
    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str:strs) {
            int[] cost = getCost(str);

            for (int i=m; i>=cost[0]; i--) {
                for (int j=n; j>=cost[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-cost[0]][j-cost[1]]+1);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 计算每一个字符串需要耗费几个0，几个1
     */
    private static int[] getCost(String str) {
        char[] chars = str.toCharArray();

        int zeroCount = 0;
        int oneCount =0;
        for(char c:chars) {
            if (c=='0') zeroCount++;
            else oneCount++;
        }

        return new int[]{zeroCount, oneCount};
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
