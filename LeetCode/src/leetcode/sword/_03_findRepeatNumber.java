package leetcode.sword;

public class _03_findRepeatNumber {
    //    找出数组中重复的数字。
//    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
//    但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//    2 <= n <= 100000
    public int findRepeatNumber(int[] nums) {
        int size = nums.length;
        boolean[] repeats = new boolean[size];
        for (int num : nums) {
            if (!repeats[num]) {
                repeats[num] = true;
            } else {
                return num;
            }
        }
        return 0;
    }
}
