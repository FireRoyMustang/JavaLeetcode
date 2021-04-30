package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/25 7:53
 *@Version V1.0
 **/
public class _897_increasingBST {
    //    给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
//    使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        _897_increasingBST increasingBST = new _897_increasingBST();
        TreeNode treeNode = increasingBST.increasingBST(root);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }

    private TreeNode preNode = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head;
        if (root.left != null) {
            head = increasingBST(root.left);
            root.left = null;
        } else {
            head = root;
        }
        if (preNode != null) {
            preNode.right = root;
        }
        preNode = root;
        increasingBST(root.right);
        return head;
    }
}
