package leetcode;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/19 14:59
 *@Version V1.0
 **/
public class totalNQueens {
    private int n;
    private boolean[] cols;
    private boolean[] leftXs;
    private boolean[] rightXs;

    public int totalNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        leftXs = new boolean[2 * n];
        rightXs = new boolean[2 * n];
        return backTrace(0);
    }

    public int backTrace(int row) {
        if (row == n) return 1;
        else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (cols[i]) continue;
                int leftX = row + i;
                if (leftXs[leftX]) continue;
                int rightX = row - i + n;
                if (rightXs[rightX]) continue;
                cols[i] = true;
                leftXs[leftX] = true;
                rightXs[rightX] = true;
                count += backTrace(row + 1);
                cols[i] = false;
                leftXs[leftX] = false;
                rightXs[rightX] = false;
            }
            return count;
        }
    }
}
