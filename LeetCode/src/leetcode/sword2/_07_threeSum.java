package leetcode.sword2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _07_threeSum {
//    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
//    请找出所有和为 0 且 不重复 的三元组。

    public static void main(String[] args) {
        _07_threeSum t = new _07_threeSum();
        System.out.println(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int mid = i + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[mid] + nums[right];
                if (nums[i] == -sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    res.add(list);
                    int tmp = nums[mid];
                    while (mid < right && nums[mid] == tmp) {
                        mid++;
                    }
                } else if (sum > -nums[i]) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return res;
    }
}
