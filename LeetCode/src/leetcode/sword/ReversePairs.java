package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/21 11:37
 *@Version V1.0
 **/
public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] test = {1, 3, 2, 3, 1};
        System.out.println(reversePairs.reversePairs(test));
    }

    private int count = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return count;
        int[] res = new int[len];
        mergeSort(nums, res, 0, len - 1);
        return count;

    }

    public void mergeSort(int[] nums, int[] res, int start, int end) {
        if (start >= end)
            return;
        int start1 = start;
        int end1 = (start + end) / 2;
        int start2 = end1 + 1;
        int lh = start2;
        int end2 = end;
        int pt = start;
        mergeSort(nums, res, start1, end1);
        mergeSort(nums, res, start2, end2);
        while (start1 <= end1 && start2 <= end2) {
            if (nums[start1] <= nums[start2]) {
                res[pt++] = nums[start1++];
                count += start2 - lh;
            } else
                res[pt++] = nums[start2++];
        }
        while (start1 <= end1) {
            res[pt++] = nums[start1++];
            count += start2 - lh;
        }
        while (start2 <= end2) {
            res[pt++] = nums[start2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }

    }

    //        int res = 0;
//        int len = nums.length;
//        if (len <= 1)
//            return res;
//        for (int i = 0; i < len - 1; i++) {
//            int tmp = nums[i];
//            for (int j = i + 1; j < len; j++) {
//                if (tmp > nums[j])
//                    res++;
//            }
//        }
//        return res;
}
