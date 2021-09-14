package leetcode.sword2;

public class _01_divide {
    //    给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
    public int divide(int a, int b) {
        int signBit = 0x80000000;
        long ans = 0, x = a, y = b;
        //不直接使用Math.abs()是为了避免除数或被除数为-2^31的情况，此时Math.abs()返回将出错
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        //示例：60/8=(60-32)/8+4=(60-32-16)/8+2+4=(60-32-16-8)/8+1+2+4=1+2+4=7
        while (x >= y) {
            long cnt = 1, base = y;
            while (x > (base << 1)) {
                cnt <<= 1;
                base <<= 1;
            }
            ans += cnt;
            x -= base;
        }
        ans = (((a ^ b) & signBit) == 0) ? ans : -ans;
        return (int) ((Integer.MAX_VALUE < ans || ans < Integer.MIN_VALUE) ? Integer.MAX_VALUE : ans);
    }
}
