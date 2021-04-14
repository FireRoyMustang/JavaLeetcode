package leetcode.jindian;

import java.util.HashMap;
import java.util.HashSet;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/12 16:01
 *@Version V1.0
 **/
public class _1_4_canPermutePalindrome {

//    给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//    回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//    回文串不一定是字典当中的单词。
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }

//    public boolean canPermutePalindrome(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
////        int counts=0;
//        for (int i = 0; i < s.length(); i++) {
//            int counts = map.getOrDefault(s.charAt(i), 0);
//            map.put(s.charAt(i), counts + 1);
//        }
//        boolean flag = false;
//        for (int counts : map.values()) {
//            if (counts % 2 == 1) {
//                if (flag) {
//                    return false;
//                }
//                flag = true;
//            }
//        }
//        return true;
//    }
}
