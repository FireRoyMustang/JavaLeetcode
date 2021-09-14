package leetcode.algorithm;

import java.util.*;

public class _987_verticalTraversal {
//    给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
//    对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
//    二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
//    返回二叉树的 垂序遍历 序列。


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    public void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }


//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        int leftBound = 0;
//        res.add(new ArrayList<>());
//        Queue<TreeNodeHelper> queue = new LinkedList<>();
//        queue.offer(new TreeNodeHelper(root, 0));
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNodeHelper nodeHelper = queue.poll();
//                TreeNode node = nodeHelper.treeNode;
//                int col = nodeHelper.col;
//                if (leftBound > col) {
//                    ArrayList<Integer> leftCol = new ArrayList<>();
//                    res.add(0, leftCol);
//                    leftBound = col;
//                }
//                int resIndex = col - leftBound;
//                if (resIndex >= res.size()) {
//                    ArrayList<Integer> rightCol = new ArrayList<>();
//                    res.add(rightCol);
//                }
//                res.get(resIndex).add(node.val);
//                if (node.left != null) {
//                    queue.add(new TreeNodeHelper(node.left, col - 1));
//                }
//                if (node.right != null) {
//                    queue.add(new TreeNodeHelper(node.right, col + 1));
//                }
//            }
//        }
//        return res;
//    }
//
//    class TreeNodeHelper {
//        TreeNode treeNode;
//        int col;
//
//        public TreeNodeHelper(TreeNode treeNode, int col) {
//            this.treeNode = treeNode;
//            this.col = col;
//        }
//    }
}
