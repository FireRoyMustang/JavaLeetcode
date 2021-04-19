package test;

import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/16 8:21
 *@Version V1.0
 **/
public class TestArrayCopy {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(arrays));
        arrays[0] = arrays[1];
        arrays[0][0] = 1;
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
        }
        System.out.println(Arrays.toString(arrays));

    }
}
