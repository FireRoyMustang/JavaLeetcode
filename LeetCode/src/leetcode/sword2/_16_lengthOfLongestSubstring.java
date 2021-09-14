package leetcode.sword2;

import java.util.HashMap;

public class _16_lengthOfLongestSubstring {
//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。

    public static void main(String[] args) {
        _16_lengthOfLongestSubstring l = new _16_lengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            res = Math.max(res, i - start);
            map.put(c, i);
        }
        return res;
    }
}
