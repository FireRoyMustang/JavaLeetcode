package leetcode.sword;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
public class _25_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode helpNode = new ListNode(-1);
        ListNode head = helpNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                helpNode.next = l1;
                l1 = l1.next;
            } else {
                helpNode.next = l2;
                l2 = l2.next;
            }
            helpNode = helpNode.next;
        }
        if (l1 != null) {
            helpNode.next = l1;
        }
        if (l2 != null) {
            helpNode.next = l2;
        }
        return head.next;
    }
}
