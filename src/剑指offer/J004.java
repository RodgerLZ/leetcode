package 剑指offer;

/**
 * 面试题04. 二维数组中的查找
 */
public class J004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        boolean flag = false;

        int i = matrix.length - 1;
        int j = 0;

        while (i>=0 && j< matrix[0].length) {
            if (matrix[i][j] == target) {
                flag = true;
                break;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }

        return flag;
    }
}
