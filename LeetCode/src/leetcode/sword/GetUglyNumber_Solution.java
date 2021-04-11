package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/10 10:48
 *@Version V1.0
 **/
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
//        if (index < 0)
//            return 0;
//        int p2 = 0;
//        int p3 = 0;
//        int p5 = 0;
//        int[] uglyNumList = new int[index];
//        uglyNumList[0] = 1;
//        for (int i = 1; i < index; i++) {
//            uglyNumList[i] = Math.min(Math.min(uglyNumList[p2] * 2, uglyNumList[p3] * 3), uglyNumList[p5] * 5);
//            if (uglyNumList[i] % 2 == 0)
//                p2++;
//            if (uglyNumList[i] % 3 == 0)
//                p3++;
//            if (uglyNumList[i] % 5 == 0)
//                p5++;
//
//        }
//        return uglyNumList[index - 1];
        if (index <= 0)
            return 0;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int tmp2 = 2;
        int tmp3 = 3;
        int tmp5 = 5;
        int[] uglyNumList = new int[index];
        uglyNumList[0] = 1;
        for (int i = 1; i < index; i++) {
            if (tmp2 < tmp3) {
                if (tmp2 < tmp5) {
                    uglyNumList[i] = tmp2;
                    p2++;
                    tmp2 = uglyNumList[p2] * 2;
                } else {
                    uglyNumList[i] = tmp5;
                    p5++;
                    tmp2 = uglyNumList[p5] * 5;
                }
            } else {
                if (tmp3 < tmp5) {
                    uglyNumList[i] = tmp3;
                    p3++;
                    tmp3 = uglyNumList[p3] * 3;
                } else {
                    uglyNumList[i] = tmp5;
                    p5++;
                    tmp5 = uglyNumList[p5] * 5;
                }
            }

        }
        return uglyNumList[index - 1];
    }
}
