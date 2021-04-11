package leetcode;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/15 17:02
 *@Version V1.0
 **/
//给定一个整数数组 nums 和一个目标值 target，
// 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
public class TwoSum {
    public double[] twoSum(int n) {
        if (n == 1)
            return new double[]{1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6};
        int all = 5 * n + 1;
        double[] res = new double[all];
        double[] tmp = twoSum(n - 1);
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < 6; j++) {//j+1是摇出的点数
                res[j + i] += tmp[i] / 6;
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{left, right};
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
