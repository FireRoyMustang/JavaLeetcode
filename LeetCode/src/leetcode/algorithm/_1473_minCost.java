package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/5 21:41
 *@Version V1.0
 **/
public class _1473_minCost {
//    在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。
//    有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
//    我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，
//    它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
//    给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
//    houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
//    cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
//    请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。
//    如果没有可用的涂色方案，请返回 -1 

//    定义 f[i][j][k],f[i][j][k] 为考虑前 i 间房子，且第 i 间房子的颜色编号为 j，
//    前 i 间房子形成的分区数量为 k 的所有方案中的「最小上色成本」。

    int INF = 0x3f3f3f3f;

    public int minCost(int[] hs, int[][] cost, int m, int n, int t) {
        int[][][] f = new int[m + 1][n + 1][t + 1];

        // 不存在分区数量为 0 的状态
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            int color = hs[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= t; k++) {
                    // 形成分区数量大于房子数量，状态无效
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }

                    // 第 i 间房间已经上色
                    if (color != 0) {
                        if (j == color) { // 只有与「本来的颜色」相同的状态才允许被转移
                            int tmp = INF;
                            // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);

                        } else { // 其余状态无效
                            f[i][j][k] = INF;
                        }

                        // 第 i 间房间尚未上色
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                        // 并将「上色成本」添加进去
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }

        // 从「考虑所有房间，并且形成分区数量为 t」的所有方案中找答案
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][t]);
        }
        return ans == INF ? -1 : ans;
    }
}
