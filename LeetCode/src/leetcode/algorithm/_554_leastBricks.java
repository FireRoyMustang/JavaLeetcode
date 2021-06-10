package leetcode.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/2 9:35
 *@Version V1.0
 **/
public class _554_leastBricks {
//    你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）
//    但是宽度不同。每一行砖块的宽度之和应该相等。你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。
//    如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，
//    这样显然是没有穿过一块砖的。给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，
//    wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线
//    穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。

    public int leastBricks(List<List<Integer>> wall) {
        // 记录每个位置的缝隙数
        HashMap<Integer, Integer> counter = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> row : wall) {
            int size = row.size();
            int cumSum = 0;
            for (int i = 0; i < size - 1; i++) {
                cumSum += row.get(i);
                int counts = counter.getOrDefault(cumSum, 0) + 1;
                maxCount = Math.max(counts, maxCount);
                counter.put(cumSum, counts);
            }
        }
        return wall.size() - maxCount;
    }

}
