package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/16 8:53
 *@Version V1.0
 **/
public class _486_PredictTheWinner {
    public static void main(String[] args) {
        _486_PredictTheWinner p = new _486_PredictTheWinner();
        System.out.println(p.PredictTheWinner(new int[]{1, 5, 2}));
    }
//    给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，
//    随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
//    每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。
//    最终获得分数总和最多的玩家获胜。
//    给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。


    // 动态规划
//    public boolean PredictTheWinner(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        for (int i = 0; i < len - 1; i++) {
//            dp[i] = nums[i];
//        }
//        for (int i = len - 2; i >= 0; i--) {
//            for (int j = i + 1; j < len; j++) {
//                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
//            }
//        }
//        return dp[len - 1] > 0;
//    }

    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int dfs(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int chooseStart = dfs(nums, start + 1, end, -turn) + turn * nums[start];
        int chooseEnd = dfs(nums, start, end - 1, -turn) + turn * nums[end];
        if (turn < 0) {
            return Math.min(chooseStart, chooseEnd);
        }
        return Math.max(chooseStart, chooseEnd);
    }
}
