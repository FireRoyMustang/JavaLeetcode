package leetcode.algorithm;

import java.util.*;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/5 21:53
 *@Version V1.0
 **/
public class _740_deleteAndEarn {
//    给你一个整数数组 nums ，你可以对它进行一些操作。
//    每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
//    之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
//    开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//    1 <= nums.length <= 2 * 104
//    1 <= nums[i] <= 104

    public static void main(String[] args) {
        _740_deleteAndEarn d = new _740_deleteAndEarn();
        System.out.println(d.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(d.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer sum = map.getOrDefault(nums[i], 0) + nums[i];
            map.put(nums[i], sum);
        }
        int pre = 0, cur = 0, lastNum = 0;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int num = entry.getKey();
            int tmp = cur;
            if (num == lastNum + 1) {
                cur = Math.max(pre + entry.getValue(), cur);
            } else {
                cur += entry.getValue();
            }
            pre = tmp;
            lastNum = num;
        }
        return cur;
    }

    public int deleteAndEarn2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
//      构造一个新的数组all
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
//      动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }


}
