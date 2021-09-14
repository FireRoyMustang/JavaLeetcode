package leetcode.algorithm;

public class _581_findUnsortedSubarray {
    public static void main(String[] args) {
        _581_findUnsortedSubarray f = new _581_findUnsortedSubarray();
        System.out.println(f.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(f.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(f.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
    }

    //    给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//    请你找出符合题意的 最短 子数组，并输出它的长度
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
//        从前往后数最后一个正确的位置是右边界，从后往前数最后一个正确的位置是左边界
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
