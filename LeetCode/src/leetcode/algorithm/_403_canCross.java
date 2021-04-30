package leetcode.algorithm;


import java.util.HashMap;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/29 20:50
 *@Version V1.0
 **/
public class _403_canCross {
    //    一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。
//    青蛙可以跳上石子，但是不可以跳入水中。
//    给你石子的位置列表 stones（用单元格序号 升序 表示）， 
//    请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
//    开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位
//    （即只能从单元格 1 跳至单元格 2 ）。
//    如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。
//     另请注意，青蛙只能向前方（终点的方向）跳跃。
//    2 <= stones.length <= 2000
//    0 <= stones[i] <= 231 - 1
//    stones[0] == 0
    public static void main(String[] args) {
        _403_canCross canCross = new _403_canCross();
        System.out.println(canCross.canCross(new int[]{0, 1}));
        System.out.println(canCross.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    boolean[][] states; // 表明是否dfs过该状态
    HashMap<Integer, Integer> map;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        map = new HashMap<>();
        if (stones[1] != 1) {
            return false;
        }
        states = new boolean[n][n];
        states[0][0] = true;
        states[1][1] = true;
        for (int i = 1; i < n; i++) {
            map.put(stones[i], i);
        }

        return dfs(1, 1, n, stones);
    }

    /**
     *
     * @param start 起点(Index)
     * @param k 上次跳的格数
     * @param n 总共多少个石子
     * @param stones
     * @return
     */
    public boolean dfs(int start, int k, int n, int[] stones) {
        if (start == n - 1) {
            return true;
        }
        for (int i = k - 1; i <= k + 1; i++) {
            int nextPoint = stones[start] + i;
            if (i <= 0 || !map.containsKey(nextPoint)) {
                continue;
            }
            int nextIndex = map.get(nextPoint);
            if (states[nextIndex][i]) {
                continue;
            }
            if (nextIndex == n - 1) {
                return true;
            }
            states[nextIndex][i] = true;
            if (dfs(nextIndex, i, n, stones)) {
                return true;
            }
        }
        return false;
    }

    public boolean canCrossDp(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

}
