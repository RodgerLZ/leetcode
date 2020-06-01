package 动态规划;

/**
 * 70. 爬楼梯
 */
public class L0070 {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;

        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;

        for (int i=2; i<n; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }

        return ints[n-1];
    }
}
