package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/27 19:21
 *@Version V1.0
 **/
public class _938_rangeSumBST {
//    给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val <= high && root.val >= low) {
            res += root.val;
        }

        int leftSum = root.val > low ? rangeSumBST(root.left, low, high) : 0;
        int rightSum = root.val < high ? rangeSumBST(root.right, low, high) : 0;
        res += leftSum + rightSum;
        return res;
    }
}
