package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/15 17:23
 *@Version V1.0
 **/
public class MaxQueue {
    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.peek() == null ? -1 : max.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.getLast() < value) {
            // 注意：这里第二个判断条件不能带等号，
            // 即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            max.removeLast();
        }
        max.add(value);

    }

    public int pop_front() {
        if (queue.size() != 0 && queue.peek() == max_value()) {
            max.poll();
        }
        return queue.peek() == null ? -1 : queue.poll();
    }
}
