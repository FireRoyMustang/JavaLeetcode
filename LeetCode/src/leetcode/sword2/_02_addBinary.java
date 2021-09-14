package leetcode.sword2;

public class _02_addBinary {
    //    给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//    输入为 非空 字符串且只包含数字 1 和 0。
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int i1 = a.length() - 1, i2 = b.length() - 1;
        while (flag || i1 >= 0 || i2 >= 0) {
            char bit = '0';
            if (flag) {
                bit += 1;
                flag = false;
            }
            if (i1 >= 0) {
                if (a.charAt(i1) == '1') {
                    bit += 1;
                }
                i1--;
            }
            if (i2 >= 0) {
                if (b.charAt(i2) == '1') {
                    bit += 1;
                }
                i2--;
            }
            switch (bit) {
                case '2':
                    bit = '0';
                    flag = true;
                    break;
                case '3':
                    bit = '1';
                    flag = true;
                    break;
            }
            sb.insert(0, bit);
        }
        return sb.toString();
    }
}
