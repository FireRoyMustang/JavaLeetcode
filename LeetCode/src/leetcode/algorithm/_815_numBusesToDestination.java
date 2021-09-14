package leetcode.algorithm;

import java.util.*;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/28 11:54
 *@Version V1.0
 **/
public class _815_numBusesToDestination {
    public static void main(String[] args) {
        _815_numBusesToDestination n = new _815_numBusesToDestination();
        System.out.println(n.numBusesToDestination(new int[][]{
                new int[]{1, 2, 7},
                new int[]{3, 6, 7},
        }, 1, 6));
        System.out.println(n.numBusesToDestination(new int[][]{
                new int[]{7, 12},
                new int[]{4, 5, 15},
                new int[]{6},
                new int[]{15, 19},
                new int[]{9, 12, 13},
        }, 15, 12));
    }
//    给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
//
//    例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会
//    一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
//    现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
//
//    求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
//
//    1 <= routes.length <= 500.
//    1 <= routes[i].length <= 105
//    routes[i] 中的所有值 互不相同
//    sum(routes[i].length) <= 105
//    0 <= routes[i][j] < 106
//    0 <= source, target < 106

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        // 某个站对应的公交车
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;

    }


    // 超出时间复杂度
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if (source == target) {
//            return 0;
//        }
//        // 表示到指定车站的公交车id
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < routes.length; i++) { // i代表公交车id
//            for (int j = 0; j < routes[i].length; j++) {
//                int destination = routes[i][j];
//                if (map.containsKey(destination)) {
//                    map.get(destination).add(i);
//                } else {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    map.put(destination, list);
//                }
//            }
//        }
////        Iterator<Integer> it = map.keySet().iterator();
////        while (it.hasNext()) {
////            Integer next = it.next();
////            System.out.println( next.toString()+": "+ map.get(next));
////        }
//        // 出发点
//        HashSet<Integer> visted = new HashSet<>();
//        visted.add(source);
//        // 从哪里出发
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(source);
//        int steps = 0;
//        while (!queue.isEmpty()) {
//            steps++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Integer start = queue.poll();
//
//                List<Integer> buses = map.get(start);
//                for (int j = 0; j < buses.size(); j++) {
//                    Integer bus = buses.get(j);
//                    for (int arrive : routes[bus]) {
//                        if (arrive == target) {
//                            return steps;
//                        }
//                        if (!visted.contains(arrive)) {
//                            queue.offer(arrive);
//                            visted.add(arrive);
//                        }
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }
}
