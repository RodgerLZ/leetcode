package 动态规划;

/**
 * 494. 目标和 (01背包-求方案数)
 */
public class L0494 {
    /**
     * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
     *
     * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     *
     * 那么让我们看看如何将其转换为子集求和问题：
     *
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * 因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
     */
    public static int findTargetSumWays(int[] nums, int S) {

        S = S < 0? -S:S;

        int sum = 0;
        for (int i:nums) {
            sum += i;
        }

        int tmp = S + sum;
        if((tmp & 1) == 1 || sum<S) return 0;

        int target = tmp/2;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i:nums) {
            for (int j=target; j>=0; j--) {
                if (i<=j) {
                    dp[j] += dp[j-i];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,2,7,9,981},1000000000));
    }
}
