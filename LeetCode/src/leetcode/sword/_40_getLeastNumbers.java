package leetcode.sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/9/4 11:39
 * @Version V1.0
 **/
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//0 <= k <= arr.length <= 10000
//0 <= arr[i] <= 10000
public class _40_getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
