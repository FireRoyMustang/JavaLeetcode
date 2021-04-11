package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/24 10:58
 *@Version V1.0
 **/
public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        System.out.println(countDigitOne.countDigitOne(11));
    }

    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int cur = n % 10;
        int high = n / 10;
        int low = 0;
        while (high > 0 || cur > 0) {
            if (cur == 0)
                res += high * digit;
            else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }
}
