package leetcode.sword;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/10/13 14:40
 * @Version V1.0
 **/
//请实现一个函数，用来判断一棵二叉树是不是对称的。
// 如果一棵二叉树和它的镜像一样，那么它是对称的。
public class _28_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        if (right == null)
            return left == null;
        return left.val == right.val &&
                helper(left.left, right.right) && helper(left.right, right.left);
    }
}
