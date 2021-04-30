package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/30 8:58
 *@Version V1.0
 **/
public class _137_singleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % 3;
        }
        return res;
    }
}
