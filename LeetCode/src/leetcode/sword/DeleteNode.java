package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/14 15:23
 *@Version V1.0
 **/
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                return newHead.next;
            }
            head = head.next;
        }
        return newHead.next;
    }
}
