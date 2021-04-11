package leetcode.sword;

import java.util.Stack;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/8 16:43
 *@Version V1.0
 **/
public class MinStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || x <= stackB.peek()) {
            stackB.push(x);
        }
    }

    public void pop() {
        if (stackB.peek().equals(stackA.pop())) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
