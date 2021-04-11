package algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/21 15:36
 *@Version V1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] test = {7, 5, 4, 6};
        mergeSort.mergeSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void mergeSort(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        mergeSort(nums, res, 0, len-1);
    }

    public void mergeSort(int[] nums, int[] res, int start, int end) {
        if (start >= end)
            return;

        int start1 = start;
        int end1 = (start + end) / 2;
        int start2 = end1 + 1;
        int end2 = end;
        int pt = start;
        mergeSort(nums, res, start1, end1);
        mergeSort(nums, res, start2, end2);
        while (start1 <= end1 && start2 <= end2) {
            if (nums[start1] < nums[start2])
                res[pt++] = nums[start1++];
            else
                res[pt++] = nums[start2++];
        }
        while (start1 <= end1) {
            res[pt++] = nums[start1++];
        }
        while (start2 <= end2) {
            res[pt++] = nums[start2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }

    }
}
