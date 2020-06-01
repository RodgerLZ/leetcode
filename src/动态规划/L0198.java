package 动态规划;

/**
 * 198. 打家劫舍
 */
public class L0198 {
    public static int rob(int[] nums) {

        int a = 0;
        int b = 0;

        for (int num : nums) {
            int c = Math.max(a + num, b);
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,4,5,3,1,1,3}));
    }
}
