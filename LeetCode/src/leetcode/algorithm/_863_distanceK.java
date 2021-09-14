package leetcode.algorithm;

import java.util.*;

public class _863_distanceK {

    //    给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//    返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
    private Map<Integer, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        findParents(root);
        dfs(target, null, k, res);
        return res;
    }

    public void findParents(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }

    public void dfs(TreeNode root, TreeNode from, int k, List<Integer> res) {
        if (k == 0) {
            res.add(root.val);
            return;
        }
        if (root.left != null && root.left != from) {
            dfs(root.left, root, k - 1, res);
        }
        if (root.right != null && root.right != from) {
            dfs(root.right, root, k - 1, res);
        }
        TreeNode parent = parents.get(root.val);
        if (parent != null && parent != from) {
            dfs(parent, root, k - 1, res);
        }
    }
}
