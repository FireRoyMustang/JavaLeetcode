package leetcode.sword;

public class _42_maxSubArray {
//    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//    要求时间复杂度为O(n)。

    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num : nums) {
            if (pre < 0) {
                pre = num;
            } else {
                pre += num;
            }
            res = Math.max(res, pre);
        }
        return res;
    }
}
