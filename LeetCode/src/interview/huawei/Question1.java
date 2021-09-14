package interview.huawei;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int[] costs = new int[N];
        List<List<Integer>> nextOpss = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            sc.next();
            costs[i] = sc.nextInt();
            ArrayList<Integer> nextOps = new ArrayList<>();
            while (sc.hasNextInt()) {
                nextOps.add(sc.nextInt());
            }
            nextOpss.add(nextOps);
        }
        int[] visited = new int[N];
        if (N != 0) {
            ans += calNextOp(0, costs, nextOpss, visited);
        }
        System.out.println(ans);
    }

    private static int calNextOp(int nextOp, int[] costs, List<List<Integer>> nextOpss, int[] visited) {
        int time = 0;
        time += costs[nextOp];
        List<Integer> nextOps = nextOpss.get(nextOp);
        if (nextOps.size() == 0) {
            return time;
        }
        int costTime = 0;
        for (Integer operation : nextOps) {
            if (visited[operation] != 0) {
                costTime = visited[operation];
            } else {
                costTime = Math.max(calNextOp(operation, costs, nextOpss, visited), costTime);
            }
        }
        time += costTime;
        visited[nextOp] = time;
        return time;
    }
}
