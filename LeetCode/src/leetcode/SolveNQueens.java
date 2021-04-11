package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/19 14:33
 *@Version V1.0
 **/
public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(5);
        System.out.println(lists);
    }

    private boolean[] col;
    private boolean[] leftX;
    private boolean[] rightX;
    private List<List<String>> res;
    private List<String> path;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        leftX = new boolean[2 * n];
        rightX = new boolean[2 * n];
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.n = n;
        backTrace(0);
        return res;
    }

    public void backTrace(int row) {
        if (row == n) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < n; i++) {//列
                if (col[i]) continue;
                int l = row + i;
                if (leftX[l]) continue;
                int r = row - i + n;
                if (rightX[r]) continue;
                col[i] = true;
                leftX[l] = true;
                rightX[r] = true;
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    builder.append('.');
                }
                builder.append('Q');
                for (int j = i + 1; j < n; j++) {
                    builder.append('.');
                }
                path.add(builder.toString());
                backTrace(row + 1);
                path.remove(path.size() - 1);
                col[i] = false;
                leftX[l] = false;
                rightX[r] = false;
            }
        }
    }
}
