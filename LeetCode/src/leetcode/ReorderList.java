package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/20 14:21
 *@Version V1.0
 **/
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reorder-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ReorderList {
    public void reorderList(ListNode head) {
        int nodeNums = -1;
        ListNode node = head;
        ArrayList<ListNode> tab = new ArrayList<>();
        while (node != null) {
            nodeNums++;
            tab.add(node);
            node = node.next;
        }
        if (nodeNums <= 1)
            return;
        node = head;
        for (int i = 0; i < nodeNums / 2; i++) {
            int index = nodeNums - i;
            ListNode insertNode = tab.get(index);
            ListNode tmp = node.next;
            node.next = insertNode;
            insertNode.next = tmp;
            node = tmp;
        }
        if (nodeNums % 2 == 0) {
            node.next = null;
        } else {
            node.next.next = null;
        }

    }
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
