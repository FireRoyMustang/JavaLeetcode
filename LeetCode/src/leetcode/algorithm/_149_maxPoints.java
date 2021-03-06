package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/24 7:41
 *@Version V1.0
 **/
public class _149_maxPoints {
    //    给你一个数组 points ，其中 points[i] = [xi, yi]
//    表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//    1 <= points.length <= 300
//    points[i].length == 2
//    -104 <= xi, yi <= 104
//    points 中的所有点 互不相同

    // 枚举所有的点，假设直线经过该点时，该直线所能经过的最多的点数。
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
