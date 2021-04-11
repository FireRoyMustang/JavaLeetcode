package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/8 17:12
 *@Version V1.0
 **/
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(this.TreeDepth(root.left) + 1, this.TreeDepth(root.right) + 1);
    }
}
