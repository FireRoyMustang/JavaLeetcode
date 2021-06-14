package leetcode.algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/13 0:00
 *@Version V1.0
 **/
public class _1449_largestNumber {
    public static void main(String[] args) {
        _1449_largestNumber l = new _1449_largestNumber();
//        System.out.println(l.largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
//        System.out.println(l.largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));
        System.out.println(l.largestNumber(new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4}, 5));
    }
//    给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
//    给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
//    总成本必须恰好等于 target 。
//    添加的数位中没有数字 0 。
//    由于答案可能会很大，请你以字符串形式返回。
//    如果按照上述要求无法得到任何整数，请你返回 "0" 。

    public String largestNumber(int[] cost, int target) {
        // dp[j]表示前i个数字中 cost 恰好为 j 的最大位数
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 9; i++) {
            int c = cost[i];
            for (int j = c; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int c = cost[i - 1];
            while (j >= c && dp[j] == dp[j - c] + 1) {
                sb.append(i);
                j -= c;
            }
        }
        return sb.toString();
    }


//    public String largestNumber(int[] cost, int target) {
//        int[][] dp = new int[10][target + 1];
//        for (int i = 0; i < 10; ++i) {
//            Arrays.fill(dp[i], Integer.MIN_VALUE);
//        }
//        int[][] from = new int[10][target + 1];
//        dp[0][0] = 0;
//        for (int i = 0; i < 9; ++i) {
//            int c = cost[i];
//            for (int j = 0; j <= target; ++j) {
//                if (j < c) {
//                    dp[i + 1][j] = dp[i][j];
//                    from[i + 1][j] = j;
//                } else {
//                    if (dp[i][j] > dp[i + 1][j - c] + 1) {
//                        dp[i + 1][j] = dp[i][j];
//                        from[i + 1][j] = j;
//                    } else {
//                        dp[i + 1][j] = dp[i + 1][j - c] + 1;
//                        from[i + 1][j] = j - c;
//                    }
//                }
//            }
//        }
//        if (dp[9][target] < 0) {
//            return "0";
//        }
//        StringBuffer sb = new StringBuffer();
//        int i = 9, j = target;
//        while (i > 0) {
//            if (j == from[i][j]) {
//                --i;
//            } else {
//                sb.append(i);
//                j = from[i][j];
//            }
//        }
//        return sb.toString();
//    }
}
