package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/13 15:10
 *@Version V1.0
 **/
// 实现函数double Power(double base, int exponent)，求base的exponent次方。
// 不得使用库函数，同时不需要考虑大数问题。

public class MyPow {
    public double myPow(double x, int n) {
        if (x == 1)
            return 1;
        double res = 1;
        double base = x;
        //要把n变为long再变负数
        //Java 代码中 int32 变量 n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，因此当 n = -2147483648n=−2147483648 时执行 n = -nn=−n 会因越界而赋值出错。解决方法是先将 nn 存入 long 变量 bb ，后面用 bb 操作即可。

        if (n < 0) {
            n = -n;
            base = 1 / x;
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                res *= base;
            }
            base *= base;
            n >>= 1;
        }
        return res;
    }
}
