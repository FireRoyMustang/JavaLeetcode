package leetcode.algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/20 8:16
 *@Version V1.0
 **/
public class _28_strStr {
//    实现 strStr() 函数。
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中
//    找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。 
//
//    说明：
//    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

    public static void main(String[] args) {
        _28_strStr strStr = new _28_strStr();
        System.out.println(Arrays.toString(strStr.getNext("aaabbab")));
    }

    // kmp
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        if (n < m) {
            return -1;
        }
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int i, j = 0;
        for (i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

//    public int strStr(String haystack, String needle) {
//        int len1 = haystack.length();
//        int len2 = needle.length();
//        if (len2 == 0) {
//            return 0;
//        }
//        if (len1 < len2) {
//            return -1;
//        }
//        for (int i = 0; i <= len1 - len2; i++) {
//            boolean flag = true;
//            for (int j = 0; j < len2; j++) {
//                if (haystack.charAt(i+j) != needle.charAt(j)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
