package leetcode.algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/15 11:53
 *@Version V1.0
 **/

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都
//围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
//如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，
//能够偷窃到的最高金额。
public class _213_rob {
    public static void main(String[] args) {
        int[] test1 = {2, 3, 2};
        _213_rob r = new _213_rob();
//        System.out.println(r.rob(test1));
//        System.out.println(r.rob(new int[]{1, 2, 3, 1}));
//        System.out.println(r.rob(new int[]{2, 1, 1, 2}));
//        System.out.println(r.rob(new int[]{1, 1, 1, 2}));
    }


    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
