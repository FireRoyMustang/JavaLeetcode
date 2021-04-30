package leetcode.algorithm;

import java.util.TreeSet;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/22 8:18
 *@Version V1.0
 **/
public class _393_maxSumSubmatrix {
    public static void main(String[] args) {
        _393_maxSumSubmatrix maxSumSubmatrix = new _393_maxSumSubmatrix();
        System.out.println(maxSumSubmatrix.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                // 求 rowSum 连续子数组 的 和
                // 和 尽量大，但不大于 k
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    private int dpmax(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> sum = new TreeSet<>();
        sum.add(0);
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i];
            Integer ceiling = sum.ceiling(tmp - k); // 找到满足范围的的最小左边界
            if (ceiling != null) {
                ans = Math.max(ans, tmp - ceiling);
            }
            if (ans == k) {
                return k;
            }
            sum.add(tmp);
        }
        return ans;
    }

//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int ans = Integer.MIN_VALUE;
//        int m = matrix.length, n = matrix[0].length;
//        for (int i = 0; i < m; ++i) { // 枚举上边界
//            int[] sum = new int[n];
//            for (int j = i; j < m; ++j) { // 枚举下边界
//                for (int c = 0; c < n; ++c) {
//                    sum[c] += matrix[j][c]; // 更新每列的元素和
//                }
//                TreeSet<Integer> sumSet = new TreeSet<Integer>();
//                sumSet.add(0);
//                int s = 0;
//                for (int v : sum) {
//                    s += v;
//                    Integer ceil = sumSet.ceiling(s - k);
//                    if (ceil != null) {
//                        ans = Math.max(ans, s - ceil);
//                    }
//                    sumSet.add(s);
//                }
//            }
//        }
//        return ans;
//    }
}
