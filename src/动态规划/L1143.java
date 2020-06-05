package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 1143. 最长公共子序列
 */
public class L1143 {

    /**
     * 动态转移方程
     * dp[i][j] 1、当chars1[i]==chars2[j]    dp[i][j] = dp[i-1][j-1] + 1
     *          2、当chars1[i]！=chars2[j]   dp[i][j] = MAX (dp[i][j-1], dp[i-1][j])
     */
    public  static int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) return 0;

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i=0; i<=chars1.length; i++) {
            for (int j=0; j<=chars2.length; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (chars1[i-1]==chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","ac"));
        System.out.println(longestCommonSubsequence("abc","ac"));
        System.out.println(longestCommonSubsequence("abc","ac"));
        System.out.println(longestCommonSubsequence("abc","ac"));
    }

    /**
     * 错误的解法
     * 思路是通过string.indexOf找到列出str1在str2中的索引，
     * 然后利用第300题目，最长上升子序列的方式求解。
     * 存在的问题：出现重复字符的时候会错误。
     */
    public static int errorMethod(String text1, String text2) {
        if (text1.length()==0 || text2.length()==0) return 0;

        List<Integer> integers = new ArrayList<>();
        char[] chars = text1.toCharArray();
        for (char c: chars) {
            int index = text2.lastIndexOf(c);
            if (index != -1) integers.add(index);
        }

        int comCharLen = integers.size();
        if (comCharLen <2) return comCharLen;

        int res = 1;
        int[] ints = new int[comCharLen];
        ints[0] = 1;
        for (int i=1; i<comCharLen; i++) {
            for(int j=0; j<i; j++) {
                if (integers.get(i) > integers.get(j)) {
                    ints[i] = Math.max(1, ints[j]+1);
                }

                ints[i] = Math.max(ints[i], 1);
            }
            res = Math.max(ints[i], res);
        }

        return res;
    }
}
