package leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/4 11:39
 *@Version V1.0
 **/
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if (len < k || k == 0)
            return res;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(i);
        }
        return res;
    }
}
