package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/17 21:04
 *@Version V1.0
 **/
public class _1_3_compressString {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        if (len == 0) {
            return "";
        }
        char preChar = S.charAt(0);
        char cur = preChar;
        int counts = 1;
        for (int i = 1; i < len; i++) {
            cur = S.charAt(i);
            if (cur != preChar) {
                sb.append(preChar);
                sb.append(counts);
                preChar = cur;
                counts = 1;
            } else {
                counts++;
            }
        }
        sb.append(preChar);
        sb.append(counts);
        return sb.length() < len ? sb.toString() : S;
    }
}
