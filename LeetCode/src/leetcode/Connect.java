package leetcode;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/10/15 9:05
 * @Version V1.0
 **/
public class Connect {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node leftMost = root;
        while (leftMost != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        Node prev = null;
//        while (!queue.isEmpty()) {
//            int size = queue.size() - 1;
//            prev = queue.poll();
//            if (prev.left != null) {
//                queue.add(prev.left);
//                queue.add(prev.right);
//            }
//            while (size-- != 0) {
//                Node node = queue.poll();
//                prev.next = node;
//                prev = node;
//                if (node.left != null) {
//                    queue.add(node.left);
//                    queue.add(node.right);
//                }
//            }
//        }
        return root;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
