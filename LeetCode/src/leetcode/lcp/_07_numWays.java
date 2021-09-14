package leetcode.lcp;

import java.util.*;

public class _07_numWays {
    public static void main(String[] args) {
        _07_numWays n = new _07_numWays();
        System.out.println(n.numWays(5, new int[][]{
                {0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4},
        }, 3));
    }
//    小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
//
//    有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
//    每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。
//    传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
//    每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
//    给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
//    返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的
//    方案数；若不能到达，返回 0。

    // dp[i][j] 表达经过i轮传达到k的方案数
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
    // bfs
//    public int numWays(int n, int[][] relation, int k) {
//        int res = 0;
//        HashMap<Integer, Set<Integer>> map = new HashMap<>();
//        for (int[] arrive : relation) {
//            int start = arrive[0], destination = arrive[1];
//            Set<Integer> set = map.getOrDefault(start, new HashSet<>());
//            set.add(destination);
//            map.put(start, set);
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        for (int i = 0; i < k; i++) {
//            int size = queue.size();
//            if (size == 0) {
//                return 0;
//            }
//            for (int j = 0; j < size; j++) {
//                Integer start = queue.poll();
//                Set<Integer> set = map.get(start);
//                if (set != null) {
//                    Iterator<Integer> it = set.iterator();
//                    while (it.hasNext()) {
//                        queue.offer(it.next());
//                    }
//                }
//            }
//        }
//        n--;
//        for (Integer end : queue) {
//            if (end == n) {
//                res++;
//            }
//        }
//        return res;
//    }
}
