package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/8 16:55
 *@Version V1.0
 **/
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        s.spiralOrder(a);
    }

    public int[] spiralOrder(int[][] matrix) {
        int up = 0, left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        int[] res = new int[(right + 1) * (down + 1)];
        int index = 0;
        while (left <= right && up <= down) {
            for (int col = left; col <= right; col++) {
                res[index++] = matrix[up][col];
            }
            up++;
            for (int row = up; row <= down; row++) {
                res[index++] = matrix[row][right];
            }
            right--;
            if (left > right || up > down) break;
            for (int col = right; col >= left; col--) {
                res[index++] = matrix[down][col];
            }
            down--;
            for (int row = down; row >= up; row--) {
                res[index++] = matrix[row][left];
            }
            left++;
        }
        return res;
    }
}
