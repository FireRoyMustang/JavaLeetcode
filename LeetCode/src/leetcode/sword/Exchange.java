package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/13 14:53
 *@Version V1.0
 **/
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
public class Exchange {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return nums;
        int forward = 0;
        int backward = len - 1;
        while (forward < backward) {
            while (forward < backward && nums[forward] % 2 != 0) forward++;
            while (forward < backward && nums[backward] % 2 == 0) backward--;
            if (forward >= backward)
                break;
            int tmp = nums[forward];
            nums[forward++] = nums[backward];
            nums[backward--] = tmp;
        }
        return nums;
    }
}
