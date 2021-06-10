package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/7 20:05
 *@Version V1.0
 **/
public class _494_findTargetSumWays {
//    给你一个整数数组 nums 和一个整数 target 。
//    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，
//    然后串联起来得到表达式 "+2-1" 。
//    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//    1 <= nums.length <= 20
//    0 <= nums[i] <= 1000
//    0 <= sum(nums[i]) <= 1000
//    -1000 <= target <= 100

    public static void main(String[] args) {
        _494_findTargetSumWays f = new _494_findTargetSumWays();
        System.out.println(f.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(f.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));
        System.out.println(f.findTargetSumWays(new int[]{1}, 1));
        System.out.println(f.findTargetSumWays(new int[]{1}, 2));
        System.out.println(f.findTargetSumWays(new int[]{1000}, 1000));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 == 1) {
            return 0;
        }
        // 问题转化成在数组 nums 中选取若干元素，使得这些元素之和等于 neg
        int neg = diff / 2;
        // dp[i][j]表示在数组前i个元素中和为j的方案数
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }

        }
        return dp[neg];
    }

//    public int findTargetSumWays(int[] nums, int target) {
//        return dfs(nums, 0, target);
//    }
//
//    public int dfs(int[] nums, int index, int target) {
//        int len = nums.length;
//        int res = 0;
//        if (index == len - 1) {
//            res += target == nums[index] ? 1 : 0;
//            res += target == -nums[index] ? 1 : 0;
//            return res;
//        }
//        return dfs(nums, index + 1, target - nums[index]) +
//                dfs(nums, index + 1, target + nums[index]);
//    }

}
