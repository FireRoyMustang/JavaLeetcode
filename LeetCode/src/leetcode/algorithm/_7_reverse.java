package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/3 2:40
 *@Version V1.0
 **/
public class _7_reverse {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
