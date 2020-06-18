package 动态规划;

/**
 * 516. 最长回文子序列
 */
public class L0516 {
    public int longestPalindromeSubseq(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        if(length==0) return 0;

        // dp[i][j] 状态定义：[i,j]子串的最长回文子序列
        int[][] dp = new int[length][length];

        for (int i=length-1; i>=0; i--) {
            dp[i][i] = 1;
            for (int j=i+1; j<length; j++) {
                // 状态转移方程
                if (chars[i]==chars[j]) dp[i][j] = dp[i+1][j-1] +2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return dp[0][length-1];
    }
}
