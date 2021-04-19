package leetcode.algorithm;

import java.util.TreeSet;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/17 8:56
 *@Version V1.0
 **/
public class _220_containsNearbyAlmostDuplicate {
    //    给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在两个下标 i 和 j，
//    使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
//    如果存在则返回 true，不存在返回 false。
//        0 <= nums.length <= 2 * 104
//        -2^31 <= nums[i] <= 2^31 - 1
//        0 <= k <= 104
//        0 <= t <= 231 - 1
    public static void main(String[] args) {
        _220_containsNearbyAlmostDuplicate contain = new _220_containsNearbyAlmostDuplicate();
        contain.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        int len = nums.length;
//        if (len == 0) {
//            return false;
//        }
//        if (k <= 0 || t < 0) {
//            return false;
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= i + k && j < len; j++) {
//                if (Math.abs(nums[i] - nums[j]) <= t) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    
//    floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
//    ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
