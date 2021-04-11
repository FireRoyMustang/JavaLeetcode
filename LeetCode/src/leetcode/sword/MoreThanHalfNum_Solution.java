package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/4 11:10
 *@Version V1.0
 **/
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
// 超过数组长度的一半，因此输出2。如果不存在则输出0。
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
//        int len = array.length;
//        if (len == 1)
//            return array[0];
//        int halfLen = len / 2;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            Integer value = map.get(array[i]);
//            if (value != null) {
//                value++;
//                if (value > halfLen)
//                    return array[i];
//                else
//                    map.put(array[i], value);
//            } else {
//                map.put(array[i], 1);
//            }
//        }
//        return 0;

        //候选法
        int len = array.length;
        int cnt = 0;
        int cond = -1;
        for (int i = 0; i < len; i++) {
            if (cnt == 0) {
                cond = array[i];
            }
            if (array[i] != cond) {
                cnt--;
            } else {
                cnt++;
            }
        }
        cnt = 0;
        for (int a : array) {
            if (a == cond)
                cnt++;
        }
        if (cnt > len / 2)
            return cond;
        else
            return 0;

    }
}
