package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/18 11:54
 *@Version V1.0
 **/
public class _1_8_setZeroes {
//    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            return;
        }
        int N = matrix[0].length;
        if (N == 0) {
            return;
        }
        boolean flagFirstRow = false;
        boolean flagFirstCol = false;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                flagFirstCol = true;
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (matrix[0][i] == 0) {
                flagFirstRow = true;
                break;
            }
        }
        for (int row = 1; row < M; row++) {
            for (int col = 1; col < N; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 1; row < M; row++) {
            if (matrix[row][0] == 0) {
                for (int i = 1; i < N; i++) {
                    matrix[row][i] = 0;
                }
            }
        }
        for (int col = 1; col < N; col++) {
            if (matrix[0][col] == 0) {
                for (int i = 1; i < M; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
        if (flagFirstCol) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagFirstRow) {
            for (int i = 0; i < N; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
