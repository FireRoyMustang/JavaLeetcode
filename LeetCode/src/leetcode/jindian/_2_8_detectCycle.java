package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/27 20:10
 *@Version V1.0
 **/
public class _2_8_detectCycle {
//    给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
//    如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
