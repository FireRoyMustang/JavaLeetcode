package leetcode.sword;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

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
}
