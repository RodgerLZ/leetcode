package 排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)
 */
public class L0056 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

        int preIndex = -1;
        int len = intervals.length;
        int[][] res = new int[len][2];

        for (int[] interval : intervals) {

            if (preIndex == -1) {
                res[0] = intervals[0];
                preIndex = 0;
                continue;
            }

            if (interval[0] <= res[preIndex][1]) {
                res[preIndex][1] = Math.max(interval[1], res[preIndex][1]);
                continue;
            }

            res[++preIndex] = interval;
        }

        return Arrays.copyOf(res, ++preIndex);
    }

    public static void main(String[] args) {
        int[][] param = {{1,3}, {2,6}, {15,18}, {8,10}};
        System.out.println(Arrays.deepToString(merge(param)));
    }
}
