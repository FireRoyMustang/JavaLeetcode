package leetcode.sword;

public class _04_findNumberIn2DArray {
    //    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
//    每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数
//    ，判断数组中是否含有该整数。
//    0 <= n <= 1000
//    0 <= m <= 1000
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
