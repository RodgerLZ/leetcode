package 动态规划;

/**
 * 152. 乘积最大子数组
 */
public class L0152 {
    public static int maxProduct(int[] nums) {

        if (nums.length==0) return 0;

        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);
            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
