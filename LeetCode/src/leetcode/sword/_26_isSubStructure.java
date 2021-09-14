package leetcode.sword;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。

public class _26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if ((B != null && A != null) && (sub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B))) {
            return true;
        }
        return false;
    }

    private boolean sub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return sub(A.left, B.left) && sub(A.right, B.right);
    }
}
