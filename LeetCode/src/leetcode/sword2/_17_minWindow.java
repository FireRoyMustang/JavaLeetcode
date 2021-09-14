package leetcode.sword2;

import java.util.HashMap;

public class _17_minWindow {
//    给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
//    如果 s 中存在多个符合条件的子字符串，返回任意一个。
//    注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//    1 <= s.length, t.length <= 105
//    s 和 t 由英文字母组成

    public static void main(String[] args) {
        System.out.println('A' - 'a');
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        //将字符串t中的字符加入HashMap计数
        for (char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }
        //count记录HashMap中字符种类的数量
        int count = charToCount.size();
        //滑动窗口
        int start = 0, end = 0;
        //记录最短字符串的起止点和长度
        int minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        //滑动窗口法
        while (end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                char endCh = s.charAt(end);
                if (charToCount.containsKey(endCh)) {
                    charToCount.put(endCh, charToCount.get(endCh) - 1);
                    if (charToCount.get(endCh) == 0) {
                        count--;
                    }
                }
                end++;
            } else {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startCh = s.charAt(start);
                if (charToCount.containsKey(startCh)) {
                    charToCount.put(startCh, charToCount.get(startCh) + 1);
                    if (charToCount.get(startCh) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
    }
}
