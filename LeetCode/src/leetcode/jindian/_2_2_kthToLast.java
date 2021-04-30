package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/24 23:10
 *@Version V1.0
 **/
public class _2_2_kthToLast {
    // 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。(k从1开始)
//    给定的 k 保证是有效的。
    public int kthToLast(ListNode head, int k) {
        ListNode node = head;
        for (int i = 1; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head.val;
    }
}
