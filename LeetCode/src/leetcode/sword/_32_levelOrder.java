package leetcode.sword;

import java.util.*;

/**
 * @Description 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Author ShenYubo
 * @Date 2020/10/8 15:33
 * @Version V1.0
 **/
public class _32_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size != 0) {
                if (flag) {
                    TreeNode node = deque.poll();
                    level.add(node.val);
                    if (node.left != null) deque.add(node.left);
                    if (node.right != null) deque.add(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    level.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                size--;
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
