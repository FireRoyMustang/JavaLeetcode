package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/6 12:56
 *@Version V1.0
 **/
public class _474_findMaxForm {
//    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//    请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[j][k]表示含有j个0和k个1的最大子集数目
        // dp[j][k] =
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            int zeros = 0, ones = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int z = m; z >= zeros; z--) {
                for (int o = n; o >= ones; o--) {
                    dp[z][o] = Math.max(dp[z][o], dp[z - zeros][o - ones]+1);
                }
            }

        }
        return dp[m][n];
    }

}
