package leetcode.jindian;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/20 18:34
 *@Version V1.0
 **/
public class _8_11_waysToChange {
//    硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
//    (结果可能会很大，你需要将结果模上1000000007)
//    0 <= n (总金额) <= 1000000

    public static void main(String[] args) {
        _8_11_waysToChange waysToChange = new _8_11_waysToChange();
        System.out.println(waysToChange.waysToChange(5));
        System.out.println(waysToChange.waysToChange(10));
    }

    static final int MOD = 1000000007;

//    dp
    static final int[] coins = {25, 10, 5, 1};
//    static final int[] coins = { 1,5,10,25};
    public int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
        }
        return f[n];
    }

//    public int waysToChange(int n) {
//        int ans = 0;
//        for (int i = 0; i * 25 <= n; ++i) {
//            int rest = n - i * 25;
//            int a = rest / 10;
//            int b = rest % 10 / 5;
//            ans = (ans + (int) ((long) (a + 1) * (a + b + 1) % MOD)) % MOD;
//        }
//        return ans;
//    }

}
