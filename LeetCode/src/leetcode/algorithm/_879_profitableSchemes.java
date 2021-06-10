package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/9 9:11
 *@Version V1.0
 **/
public class _879_profitableSchemes {
    public static void main(String[] args) {
        _879_profitableSchemes p = new _879_profitableSchemes();
        System.out.println(p.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(p.profitableSchemes(5, 0, new int[]{2, 2}, new int[]{2, 3}));
    }

    //    集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
//    第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。
//    如果成员参与了其中一项工作，就不能参与另一项工作。
//    工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
//    有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
    final static int MOD = 1000000000 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        // dp[j][k]表示到序号 i 的工作为止, j 名员工获取至少 k 的利润的方案数
        int[][] dp = new int[n + 1][minProfit + 1];
        // 当没有任何工作时, 所有人都无法参加工作, 也可以获得0的利润, 因此方案数为1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < len; i++) {
            int g = group[i];
            int p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    // 因为是至少获取k的利润，因此右侧为max(k-p,0)
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    dp[j][k] %= MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
//    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//        int len = group.length;
//        // dp[j][k]表示到序号 i 的工作为止, j 名员工获取至少 k 的利润的方案数
//        int[][] dp = new int[n + 1][minProfit + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < len; i++) {
//            int g = group[i];
//            int p = profit[i];
//            for (int j = n; j >= g; j--) {
//                for (int k = minProfit; k >= 0; k--) {
//                    dp[j][k] += dp[j - g][Math.max((k - p), 0)];
//                    dp[j][k] %= MOD;
//                }
//            }
//        }
//        return dp[n][minProfit];
//    }
}
