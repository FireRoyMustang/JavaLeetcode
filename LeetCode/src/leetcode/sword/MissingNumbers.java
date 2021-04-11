package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/21 10:20
 *@Version V1.0
 **/
public class MissingNumbers {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return -1;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;
    }
}
