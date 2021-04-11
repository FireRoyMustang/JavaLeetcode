package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/27 9:07
 *@Version V1.0
 **/
public class PreorderTraversal {
//    ArrayList<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
//        dfs(root);
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return res;
    }

//    public void dfs(TreeNode node) {
//        if (node == null)
//            return;
//        res.add(node.val);
//        if (node.left != null) dfs(node.left);
//        if (node.right != null) dfs(node.right);
//    }
}
