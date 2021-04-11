package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/8 15:17
 *@Version V1.0
 **/
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0)
            return 0;
//        int[] maxTil = new int[len];
//        int res;
//        res = maxTil[0] = array[0];
//        for (int i = 1; i < len; i++) {
//            if (maxTil[i - 1] < 0) {
//                maxTil[i] = array[i];
//            } else {
//                maxTil[i] = maxTil[i - 1] + array[i];
//            }
//            if (maxTil[i] > res)
//                res = maxTil[i];
//        }
        int tmp = 0;
        int res = array[0];
        for (int i = 0; i < len; i++) {
            tmp += array[i];
            res = tmp > res ? tmp : res;
            if (tmp < 0)
                tmp = 0;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(arr));
    }
}
