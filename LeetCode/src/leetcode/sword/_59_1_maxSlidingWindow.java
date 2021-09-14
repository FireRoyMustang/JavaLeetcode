package leetcode.sword;

import java.util.Arrays;
import java.util.LinkedList;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
public class _59_1_maxSlidingWindow {
    public static void main(String[] args) {
//        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] tes = {5183, 2271, 3067, 539, 8939, 2999, 9264, 737, 3974, 5846, -210, 9278, 5800, 2675, 6608, 1133, -1, 6018, 9672, 5179, 9842, 7424, -209, 2988, 2757, 5984, 1107, 2644, -499, 7234, 7539, 6525, 347, 5718, -742, 1797, 5292, 976, 8752, 8297, 1312, 3385, 5924, 2882, 6091, -282, 2595, 96, 1906, 8014, 7667, 5895, 7283, 7974, -167, 7068, 3946, 6223, 189, 1589, 2058, 9277, -302, 8157, 8256, 5261, 8067, 1071, 9470, 2682, 8197, 5632, 753, 3179, 8187, 9042, 8167, 4657, 7080, 7801, 5627, 7917, 8085, 928, -892, -427, 3685, 4676, 2431, 8064, 8537, 343, 505, 4352, 2108, 4399, 66, 2086, 1922, 9126, 9460, 393, 443, 5689, 7595, 850, 8493, 2866, 732, 3738, 7933, 3666, 2370, 5804, 4045, 7903, 8009, 5387, 5542, 7593, 6862, 1547, 6934, -160, 9693, 4560, 7429, 9989};
        System.out.println(tes.length);
        System.out.println(Arrays.toString(maxSlidingWindow(tes, 100)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> window = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (max.size() != 0 && max.getLast() < nums[i]) {
                max.removeLast();
            }
            max.add(nums[i]);
            window.add(nums[i]);
        }
        for (int i = k - 1; i < len; i++) {
            while (max.size() != 0 && max.getLast() < nums[i]) {
                max.removeLast();
            }
            max.add(nums[i]);
            window.add(nums[i]);
            res[i - k + 1] = max.getFirst();
            if (window.removeFirst() == max.getFirst()) {
                max.removeFirst();
            }
        }
        return res;
    }
}
