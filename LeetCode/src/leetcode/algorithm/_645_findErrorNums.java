package leetcode.algorithm;

import java.util.Arrays;


public class _645_findErrorNums {
    public static void main(String[] args) {
        _645_findErrorNums f = new _645_findErrorNums();
        System.out.println(Arrays.toString(f.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(f.findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(f.findErrorNums(new int[]{3, 2, 2})));
    }

//    集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
//    导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
//
//    给定一个数组 nums 代表了集合 S 发生错误后的结果。
//    请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int[] map = new int[nums.length];
        for (int num : nums) {
            map[num - 1]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map[i] == 0) {
                res[1] = i + 1;
                count++;
            }
            if (map[i] == 2) {
                res[0] = i + 1;
                count++;
            }
            if (count == 2) {
                return res;
            }
        }
        return res;
    }

}
