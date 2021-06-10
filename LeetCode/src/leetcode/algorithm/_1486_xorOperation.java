package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/7 9:15
 *@Version V1.0
 **/
public class _1486_xorOperation {
//    给你两个整数，n 和 start 。
//    数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
//    请返回 nums 中所有元素按位异或（XOR）后得到的结果。

    public static void main(String[] args) {
        _1486_xorOperation x = new _1486_xorOperation();
        System.out.println(x.xorOperation(4, 3));//8
    }

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= 2 * i + start;
        }
//        if (n % 2 == 1) {
//            res ^= start;
//        }
        return res;
    }
}
