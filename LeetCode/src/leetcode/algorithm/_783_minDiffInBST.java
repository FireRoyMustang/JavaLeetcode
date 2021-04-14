package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/13 8:06
 *@Version V1.0
 **/
public class _783_minDiffInBST {
    //    给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//    树中节点数目在范围 [2, 100] 内
    Integer preNum = null;
    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new _783_minDiffInBST().res);
    }

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (preNum != null) {
            res = Math.min(res, root.val - preNum);
        }
        preNum = root.val;
        inOrder(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
