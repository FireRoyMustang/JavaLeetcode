package leetcode.algorithm;

import java.util.HashMap;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/2 15:32
 *@Version V1.0
 **/
public class _532_checkSubarraySum {
//    给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//
//    子数组大小 至少为 2 ，且
//    子数组元素总和为 k 的倍数。
//    如果存在，返回 true ；否则，返回 false 。
//
//    如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
//    1 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^9
//    0 <= sum(nums[i]) <= 2^31 - 1
//    1 <= k <= 231 - 1

    public static void main(String[] args) {
        _532_checkSubarraySum c = new _532_checkSubarraySum();
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        // (余数，index)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remain = 0; // 只需要记录余数，找到另一个余数相同且距离为2
        for (int index = 0; index < len; index++) {
            remain = (remain + nums[index]) % k;
            if (map.containsKey(remain)) {
                if (index - map.get(remain) >= 2) {
                    return true;
                }
            } else {
                map.put(remain, index);
            }
        }
        return false;

//        暴力超时
//        int len = nums.length;
//        for (int left = 0; left < len; left++) {
//            int sum = nums[left];
//            for (int right = left + 1; right < len; right++) {
//                sum += nums[right];
//                if (sum % k == 0) {
//                    return true;
//                }
//            }
//        }
//        return false;
    }
}
