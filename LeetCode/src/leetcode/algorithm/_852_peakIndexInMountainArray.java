package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/15 12:19
 *@Version V1.0
 **/
public class _852_peakIndexInMountainArray {
//    符合下列属性的数组 arr 称为 山脉数组 ：
//    arr.length >= 3
//    存在 i（0 < i < arr.length - 1）使得：
//    arr[0] < arr[1] < ... arr[i-1] < arr[i]
//    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//    给你由整数组成的山脉数组 arr ，
//    返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i]
//                arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//    的下标 i 。

//    3 <= arr.length <= 104
//    0 <= arr[i] <= 106
//    题目数据保证 arr 是一个山脉数组

    public static void main(String[] args) {
        _852_peakIndexInMountainArray p = new _852_peakIndexInMountainArray();
        System.out.println(p.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
