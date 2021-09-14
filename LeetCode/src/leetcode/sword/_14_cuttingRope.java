package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/16 15:41
 *@Version V1.0
 **/
public class _14_cuttingRope {
    public static void main(String[] args) {
        System.out.println(new _14_cuttingRope().cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return n - 1;
        if (n == 4)
            return n;
        if (n > 6)
            return 3 * cuttingRope(n - 3);
        else
            return 3 * (n - 3);


//        if(n <= 3) return n - 1;
//        int a = n / 3, b = n % 3;
//        if(b == 0) return (int)Math.pow(3, a);
//        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
//        return (int)Math.pow(3, a) * 2;
//
//        作者：jyd
//        链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }
}