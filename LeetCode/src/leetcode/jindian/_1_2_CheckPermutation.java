package leetcode.jindian;


import java.util.HashMap;
import java.util.Map;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/11 10:26
 *@Version V1.0
 **/

public class _1_2_CheckPermutation {
    //    0 <= len(s1) <= 100
//    0 <= len(s2) <= 100
//    给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char c = s1.charAt(i);
            map.put(s1.charAt(i), map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len1; i++) {
            char c = s2.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }
}
