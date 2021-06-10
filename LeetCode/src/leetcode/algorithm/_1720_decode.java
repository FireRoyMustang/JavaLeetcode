package leetcode.algorithm;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/6 9:55
 *@Version V1.0
 **/
public class _1720_decode {
    //    未知 整数数组 arr 由 n 个非负整数组成。
//    经编码后变为长度为 n - 1 的另一个整数数组 encoded ，
//    其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1]
//    经编码后得到 encoded = [1,2,3] 。
//    给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
//    请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
    public static void main(String[] args) {
        _1720_decode d = new _1720_decode();
        System.out.println(Arrays.toString(d.decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(d.decode(new int[]{6, 2, 7, 3}, 4)));
    }

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res = new int[n + 1];
        res[0] = first;
        for (int i = 0; i < n; i++) {
            res[i + 1] = encoded[i] ^ res[i];
        }
        return res;
    }
}
