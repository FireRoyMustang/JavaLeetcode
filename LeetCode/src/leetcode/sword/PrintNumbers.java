package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/14 15:32
 *@Version V1.0
 **/
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int bound = 1;
        while (n != 0) {
            bound *= 10;
            n--;
        }
        int[] res = new int[bound - 1];
        for (int i = 0; i < bound - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
