package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/19 18:38
 *@Version V1.0
 **/
public class _1_9_isFlipedString {
    //    字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
//    （比如，waterbottle是erbottlewat旋转后的字符串）。
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        String s = s2 + s2;
        if (s.contains(s1)) {
            return true;
        }
        return false;
    }
//    public boolean isFlipedString(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        if (len1 != len2) {
//            return false;
//        }
//        if (len1 == 0) {
//            return true;
//        }
//        char startChar = s1.charAt(0);
//        for (int i = 0; i < len2; i++) {
//            if (startChar == s2.charAt(i)) {
//                if (s1.startsWith(s2.substring(i)) && s1.endsWith(s2.substring(0, i))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
