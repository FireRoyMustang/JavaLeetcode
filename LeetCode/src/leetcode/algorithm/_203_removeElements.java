package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/5 10:21
 *@Version V1.0
 **/
public class _203_removeElements {
    //    给你一个链表的头节点 head 和一个整数 val ，
//    请你删除链表中所有满足 Node.val == val 的节点，
//    并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        ListNode helpNode = new ListNode(-1, head);
        ListNode prev = helpNode;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return helpNode.next;
    }
}
