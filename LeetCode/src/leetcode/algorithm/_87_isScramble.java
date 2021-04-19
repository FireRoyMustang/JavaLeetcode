package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/17 8:30
 *@Version V1.0
 **/
public class _87_isScramble {
//    使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
//    如果字符串的长度为 1 ，算法停止
//    如果字符串的长度 > 1 ，执行下述步骤：
//    在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，
//    则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
//    随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。
//    即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
//    在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
//    给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
//    如果是，返回 true ；否则，返回 false 。


    // 记忆化搜索存储状态的数组
    // -1 表示 false，1 表示 true，0 表示未计算
    int[][][] memo;
    String s1, s2;

    // dp表示s1的index起，与s2的index起，对于length长度是否相同
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        this.memo = new int[length][length][length + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    // 第一个字符串从 i1 开始，第二个字符串从 i2 开始，子串的长度为 length，是否和谐
    public boolean dfs(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0) {
            return memo[i1][i2][length] == 1;
        }

        // 判断两个子串是否相等
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }

        // 判断是否存在字符 c 在两个子串中出现的次数不同
        if (!checkIfSimilar(i1, i2, length)) {
            memo[i1][i2][length] = -1;
            return false;
        }

        // 枚举分割位置
        for (int i = 1; i < length; ++i) {
            // 不交换的情况
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
            // 交换的情况
            if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }

        memo[i1][i2][length] = -1;
        return false;
    }

    public boolean checkIfSimilar(int i1, int i2, int length) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = i1; i < i1 + length; ++i) {
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + length; ++i) {
            char c = s2.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}