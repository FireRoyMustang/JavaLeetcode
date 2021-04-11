package leetcode.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/18 17:42
 *@Version V1.0
 **/
//输入一棵二叉树的根节点，求该树的深度。
// 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null)
            queue.add(root);
        else
            return 0;
        while (queue.size() != 0) {
            int currentSize = queue.size();
            while (currentSize-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
        //后序遍历
//        if (root == null)
//            return 0;
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
