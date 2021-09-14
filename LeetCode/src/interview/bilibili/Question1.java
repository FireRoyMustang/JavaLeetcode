package interview.bilibili;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(GetSortedTasks(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6, 7}})));
    }

    public static int[] GetSortedTasks(int[][] taskLists) {
        int m = taskLists.length;
        if (m == 0) {
            return new int[0];
        }
        int n = taskLists[0].length;
        if (m == 1) {
            Arrays.sort(taskLists[0]);
            return taskLists[0];
        }
        int[] res = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(taskLists[i], 0, res, index, n);
            index += n;
        }
        Arrays.sort(res);
        return res;
    }

    /* Write Code Here */
    public static int[] GetLeastNumbers(int[] input, int k) {
        int len = input.length;
        if (len <= k) {
            return input;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            heap.offer(input[i]);
        }
        for (int i = k; i < len; i++) {
            if (input[i] < heap.peek()) {
                heap.poll();
                heap.offer(input[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }


}