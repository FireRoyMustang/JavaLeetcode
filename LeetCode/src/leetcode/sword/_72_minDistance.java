package leetcode.sword;


/**
 * @Description
 * @Author ShenYubo
 * @Date 2021/4/15 22:40
 * @Version V1.0
 **/
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符
//0 <= word1.length, word2.length <= 500
//word1 和 word2 由小写英文字母组成

public class _72_minDistance {
    public static void main(String[] args) {

    }
//    public int minDistance(String word1, String word2) {
//        int len1 = word1.length(), len2 = word2.length();
//        int[][] dp = new int[len1 + 1][len2 + 1];
//        // dp[i][j]表示前i个字符到前j个字符的最短距离
//        for (int i = 1; i <= len1; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 1; i <= len2; i++) {
//            dp[0][i] = i;
//        }
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
//                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]),
//                            dp[i][j] - 1);
//                } else {
//                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]),
//                            dp[i][j]);
//                }
//            }
//        }
//        return dp[len1][len2];
//    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        int[][] dp = new int[2][len2 + 1];
        // dp[i][j]表示前i个字符到前j个字符的最短距离
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1; i++) {
            dp[1][0] = i + 1;
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[1][j + 1] = 1 + Math.min(Math.min(dp[1][j], dp[0][j + 1]),
                            dp[0][j] - 1);
                } else {
                    dp[1][j + 1] = 1 + Math.min(Math.min(dp[1][j], dp[0][j + 1]),
                            dp[0][j]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, len2 + 1);
        }
        return dp[1][len2];
    }
}
