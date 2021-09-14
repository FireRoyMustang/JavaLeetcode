package leetcode.sword;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/10/14 15:32
 * @Version V1.0
 **/
public class _17_printNumbers {
    // 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
    // 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
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
