package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/14 15:40
 *@Version V1.0
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
//            if ((n & 1) == 1)
//                res++;
//            n >>= 1;
        }
        return res;
    }
}
