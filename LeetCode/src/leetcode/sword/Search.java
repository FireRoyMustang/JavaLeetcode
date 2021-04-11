package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/21 9:44
 *@Version V1.0
 **/
public class Search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                res++;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (res > 0) {
            int pt = mid - 1;
            mid++;
            while (pt >= 0) {
                if (nums[pt--] != target) {
                    break;
                } else {
                    res++;
                }
            }
            while (mid < nums.length) {
                if (nums[mid++] != target)
                    break;
                else {
                    res++;
                }
            }
        }
        return res;
    }
}
