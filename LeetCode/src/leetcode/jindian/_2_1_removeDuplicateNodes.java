package leetcode.jindian;

import java.util.HashSet;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/23 20:11
 *@Version V1.0
 **/
public class _2_1_removeDuplicateNodes {
    //    编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            if (set.contains(node.val)) {
                pre.next = node.next;
            } else {
                pre = node;
                set.add(node.val);
            }
            node = node.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
