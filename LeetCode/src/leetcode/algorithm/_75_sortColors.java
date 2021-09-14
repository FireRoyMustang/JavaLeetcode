package leetcode.algorithm;

import java.util.Arrays;

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
public class _75_sortColors {
    public static void main(String[] args) {
        _75_sortColors s = new _75_sortColors();
//        int[] ints = {2, 0, 2, 1, 1, 0};
//        int[] ints = {2, 0, 1};
        int[] ints = {1, 2, 0};
        s.sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right && nums[left] == 0) {
            left++;
        }
        while (left < right && nums[right] == 2) {
            right--;
        }
        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[right];
                nums[right--] = 2;
            }
        }
    }
}
