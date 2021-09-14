package leetcode.sword;


import java.util.Stack;

public class _6_reversePrint {
    //    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
