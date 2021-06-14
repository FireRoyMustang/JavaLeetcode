package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/11 6:29
 *@Version V1.0
 **/
public class _279_numSquares {
    public static void main(String[] args) {
        _279_numSquares n = new _279_numSquares();
        System.out.println(n.numSquares(12));
        System.out.println(n.numSquares(13));
        System.out.println(n.numSquares(1));
    }

    //    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
//    使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//    给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
//    其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    public int numSquares(int n) {
        // dp[i]表示组成 i+1 的最少的个数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int square = j * j;
                if (square > i) {
                    break;
                }
                if (dp[i] == 0) {
                    dp[i] = dp[i - square] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }
        return dp[n];
    }
}
