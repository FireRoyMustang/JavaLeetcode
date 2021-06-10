package leetcode.algorithm;

import java.util.HashMap;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/3 22:51
 *@Version V1.0
 **/
public class _525_findMaxLength {
    //    给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        // (前缀和, index)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                res = Math.max(res, (i - map.get(sum)));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
