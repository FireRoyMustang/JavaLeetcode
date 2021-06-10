package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/9 10:52
 *@Version V1.0
 **/
public class _1482_minDays {
    //    给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
//    现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
//    花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
//    请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
//    bloomDay.length == n
//    1 <= n <= 10^5
//    1 <= bloomDay[i] <= 10^9
//    1 <= m <= 10^6
//    1 <= k <= n

    public static void main(String[] args) {
        _1482_minDays m = new _1482_minDays();
        System.out.println(m.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(m.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(m.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(m.minDays(new int[]{1000000000, 1000000000}, 1, 1));
        System.out.println(m.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }

    int n;

    public int minDays(int[] bloomDay, int m, int k) {
        int allNeed = m * k;
        n = bloomDay.length;
        if (allNeed > n) {
            return -1;
        }
        int right = 0;
        int left = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, bloomDay[i]);
            left = Math.min(left, bloomDay[i]);
        }
        if (allNeed == n) {
            return right;
        }
        int days;
        while (left < right) {
            days = (left + right) >> 1;
            if (judge(bloomDay, m, k, days)) {
                right = days;
            } else {
                left = days + 1;
            }
        }
        return left;
    }

    // 在指定日期内能否完成
    public boolean judge(int[] bloomDay, int m, int k, int days) {
        int adjacentNum = 0;
        for (int i = 0; i < n; i++) {
            if (days >= bloomDay[i]) {
                adjacentNum++;
                if (adjacentNum == k) {
                    m--;
                    adjacentNum = 0;
                }
            } else {
                adjacentNum = 0;
            }
        }
        return m <= 0;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
