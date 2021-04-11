package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/18 14:31
 *@Version V1.0
 **/
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        ArrayList<Integer> fi = new ArrayList<>();
        for (int num : nums) {
            fi.add(num);
        }
        res.add(fi);
        while (true) {
            List<Integer> perm = nextPerm(nums);
            if (perm == null)
                break;
            else {
                res.add(perm);
            }
        }
        return res;
    }

    public List<Integer> nextPerm(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
        if (i == -1) return null;
        int j = len - 1;
        for (; j >= 0 && nums[j] <= nums[i]; j--) ;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        for (int a = i + 1, b = len - 1; a < b; a++, b--) {
            tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
}
