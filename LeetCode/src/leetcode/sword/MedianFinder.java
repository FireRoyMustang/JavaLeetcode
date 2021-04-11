package leetcode.sword;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/28 15:55
 *@Version V1.0
 **/
public class MedianFinder {
    Queue<Integer> smaller;
    Queue<Integer> bigger;

    public MedianFinder() {
        bigger = new PriorityQueue<>();
        smaller = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (smaller.size() != bigger.size()) {
//            bigger.add(num);
//            smaller.add(bigger.poll());
            if (num < bigger.peek()) {
                smaller.add(num);
            } else {
                smaller.add(bigger.poll());
                bigger.add(num);
            }
        } else {
//            smaller.add(num);
//            bigger.add(smaller.poll());
            if (num > smaller.peek()) {
                bigger.add(num);
            } else {
                bigger.add(smaller.poll());
                smaller.add(num);
            }
        }
    }

    public double findMedian() {
        return smaller.size() == bigger.size() ?
                (smaller.peek() + bigger.peek()) / 2.0 : bigger.peek();
    }
}
