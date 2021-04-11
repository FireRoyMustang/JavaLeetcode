package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/27 11:30
 *@Version V1.0
 **/
public class MinArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int i = 0;
        int j = len - 1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            if (numbers[mid] < numbers[j]) {
                j = mid;
            } else if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else
                j--;
        }
        return numbers[mid];
//        if (len == 1)
//            return numbers[0];
//        for (int i = 1; i < len; i++) {
//            if (numbers[i] < numbers[i - 1])
//                return numbers[i];
//        }
//        return numbers[0];
    }
}
