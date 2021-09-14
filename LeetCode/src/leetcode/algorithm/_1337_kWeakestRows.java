package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1337_kWeakestRows {

    //    给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
//    请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
//    如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//    军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
    public static void main(String[] args) {
        _1337_kWeakestRows k = new _1337_kWeakestRows();
        int[][] ints = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        for (int[] anInt : ints) {
            System.out.println(k.countSoldiers2(anInt, 5));
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < m; i++) {
            heap.offer(new int[]{i, countSoldiers(mat[i], n)});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    private int countSoldiers(int[] row, int n) {
        int left = 0, right = n - 1, pos = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (row[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
                pos = mid;
            }
        }
        return pos + 1;
    }

    private int countSoldiers2(int[] row, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (row[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == n ? n : row[left] == 1 ? left + 1 : left;
    }

}
