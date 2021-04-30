package leetcode.algorithm;

import java.util.Collections;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/26 8:20
 *@Version V1.0
 **/

public class _1011_shipWithinDays {
    //    传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//    传送带上的第 i 个包裹的重量为 weights[i]。每一天，
//    我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//    返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//    1 <= D <= weights.length <= 50000
//    1 <= weights[i] <= 500
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        int maxWeight = 0, sumWeight = 0;
        for (int i = 0; i < len; i++) {
            maxWeight = Math.max(weights[i], maxWeight);
            sumWeight += weights[i];
        }
        if (D == len) {
            return maxWeight;
        }
        int left = maxWeight, right = sumWeight;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int days = loadNeedDays(mid, weights, D);
            if (days > D) {
                left = mid + 1;
            } else if (days < D) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回该负载需要的天数(最多为 D + 1)
     * @param load
     * @param weights
     * @param D
     * @return
     */
    public int loadNeedDays(int load, int[] weights, int D) {
        int loaded = 0;
        int days = 1;
        for (int i = 0; i < weights.length && days <= D; i++) {
            loaded += weights[i];
            if (loaded > load) {
                loaded = weights[i];
                days++;
            }
        }
        return days;
    }
}
