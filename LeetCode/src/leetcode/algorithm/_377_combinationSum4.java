package leetcode.algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/24 8:21
 *@Version V1.0
 **/
public class _377_combinationSum4 {
//    给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
//    请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//    题目数据保证答案符合 32 位整数范围。

    public static void main(String[] args) {
        _377_combinationSum4 combinationSum4 = new _377_combinationSum4();
        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示编号为i组成的方案数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) {
                    continue;
                }
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
//    public int combinationSum4(int[] nums, int target) {
//        // dp[i] 表示组成的方案数
//        int[][] dp = new int[nums.length][target + 1];
//        for (int i = 1; i <= target; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] > i) {
//                    continue;
//                }
//                dp[i] += dp[i - nums[j]] + 1;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[target];
//    }
}
