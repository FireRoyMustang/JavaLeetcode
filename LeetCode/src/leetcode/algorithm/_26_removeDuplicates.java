package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/18 8:52
 *@Version V1.0
 **/
public class _26_removeDuplicates {

    //    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
//    返回删除后数组的新长度。
//    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//    0 <= nums.length <= 3 * 104
//    -104 <= nums[i] <= 104
//    nums 已按升序排列
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int ptr = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                nums[ptr++] = pre;
            }
        }
        return ptr;
    }
}
