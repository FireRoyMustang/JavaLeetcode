package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/4 10:00
 *@Version V1.0
 **/
public class _160_getIntersectionNode {
    //    给你两个单链表的头节点 headA 和 headB ，
//    请你找出并返回两个单链表相交的起始节点。
//    如果两个链表没有交点，返回 null 。
//    题目数据 保证 整个链式结构中不存在环
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
