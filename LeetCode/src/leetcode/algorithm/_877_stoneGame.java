package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/16 8:22
 *@Version V1.0
 **/
public class _877_stoneGame {
    //    亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
//    游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//    亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
//    这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//    假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
//    2 <= piles.length <= 500
//    piles.length 是偶数。
//    1 <= piles[i] <= 500
//    sum(piles) 是奇数。

    // 注：先手必胜
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        // dp[i][j]表示 i 到 j 的石子堆，当前玩家与另一个玩家的石子数量之差的最大值
        // dp[i][j] = max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

//    public boolean stoneGame(int[] piles) {
//        int length = piles.length;
//        int[] dp = new int[length];
//        for (int i = 0; i < length; i++) {
//            dp[i] = piles[i];
//        }
//        for (int i = length - 2; i >= 0; i--) {
//            for (int j = i + 1; j < length; j++) {
//                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
//            }
//        }
//        return dp[length - 1] > 0;
//    }
}
