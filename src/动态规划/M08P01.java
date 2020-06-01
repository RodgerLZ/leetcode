package 动态规划;

/**
 * 面试题 08.01. 三步问题
 */
public class M08P01 {
    public static int waysToStep(int n) {

        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 4;

        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 4;

        for (int i=3; i<n; i++) {
            // 注意点：为防止溢出，按题目要求每次相加需要取模
            ints[i] = ((ints[i-1] + ints[i-2])%1000000007 + ints[i-3])%1000000007;
        }

        return ints[n-1];
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(3));
        System.out.println(waysToStep(5));
        System.out.println(waysToStep(76));
    }
}
