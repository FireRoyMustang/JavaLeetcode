package leetcode.algorithm;


import java.util.Arrays;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/5/8 8:52
 *@Version V1.0
 **/
public class _1723_minimumTimeRequired {
//    给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
//    请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
//    工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，
//    使工人的 最大工作时间 得以 最小化 。
//    返回分配方案中尽可能 最小 的 最大工作时间
//    1 <= k <= jobs.length <= 12
//    1 <= jobs[i] <= 107。

    public static void main(String[] args) {
        _1723_minimumTimeRequired m = new _1723_minimumTimeRequired();
        System.out.println(m.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    int K, n;

    public int minimumTimeRequired(int[] jobs, int k) {
        n = jobs.length;
        int maxTime = 0, sumTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, jobs[i]);
            sumTime += jobs[i];
        }
        if (k == n) {
            return maxTime;
        }
        Arrays.sort(jobs);
        this.K = k;
        int left = maxTime, right = sumTime;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(jobs, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] jobs, int limit) {
        int[] workLoads = new int[K];
        return backtrace(jobs, workLoads, n - 1, limit);
    }

    /**
     *
     * @param jobs
     * @param workLoads
     * @param i 表示分配到了第i个工作，从后向前分配
     * @param limit
     * @return
     */
    public boolean backtrace(int[] jobs, int[] workLoads, int i, int limit) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < K; j++) {
            if (workLoads[j] + jobs[i] <= limit) {
                workLoads[j] += jobs[i];
                if (backtrace(jobs, workLoads, i - 1, limit)) {
                    return true;
                }
                workLoads[j] -= jobs[i];
            }
            // 此时尝试给下一位工人分配工作
            // 如果当前工人工作量为0都不足以分配工作，则证明任何工作都无法分配
            // 如果当前工人分配工作满都不足以完成下一次分配，则同上
            if (workLoads[j] == 0 || workLoads[j] + jobs[i] == limit) {
                break;
            }
        }
        return false;
    }
}
