package leetcode.sword2;


public class _51_maxPathSum {
//    路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
//    该路径 至少包含一个 节点，且不一定经过根节点。
//    路径和 是路径中各节点值的总和。
//    给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (res < left + right + root.val) res = left + right + root.val;
        return Math.max(0, Math.max(left, right) + root.val);
    }
}

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
