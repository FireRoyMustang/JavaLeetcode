package leetcode.sword2;

public class _03_countBits {
//    给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
//    给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
//    要求算法的空间复杂度为 O(n) 。
//    你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。      

    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) { //偶数
                ans[i] = ans[i >> 1];
            } else { //奇数
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }
}
