package leetcode.sword;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class _27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
