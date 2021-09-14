package leetcode.sword2;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/9/14 10:32
 *@Version V1.0
 **/
// 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
public class _24_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


