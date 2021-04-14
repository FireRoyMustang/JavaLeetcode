package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/12 17:28
 *@Version V1.0
 **/
public class _1_5_oneEditAway {
    //    字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
//    编写一个函数判定它们是否只需要一次(或者零次)编辑。
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < len1 && j < len2; ) {
            if (first.charAt(i++) != second.charAt(j++)) {
                if (flag) {
                    return false;
                }
                flag = true;
                if (len1 < len2) {
                    i--;
                } else if (len1 > len2) {
                    j--;
                }
            }
        }
        return true;
    }
}
