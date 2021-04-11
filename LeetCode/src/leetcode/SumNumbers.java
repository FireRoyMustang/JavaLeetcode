package leetcode;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/29 10:26
 *@Version V1.0
 **/
public class SumNumbers {
    private int cur = 0;
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return sum;
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node) {
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
        }
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
        cur /= 10;
    }
}
