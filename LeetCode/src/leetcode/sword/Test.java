package leetcode.sword;


import java.util.*;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/1 14:23
 *@Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list2.add(1);
        System.out.println(list1.removeFirst() == list2.getFirst());
        System.out.println(higher(0.9739, 0.9641));
//        calBai(new double[]{17.92, 17.32, 20.80},25.17);
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(0);
        integers.add(2);
        System.out.println(integers.peek());

        int i7 = 10;
        i7 = i7++;
        System.out.println("i7 = " + i7);
        i7 = ++i7;
        System.out.println("i7 = " + i7);

        boolean[] booleans = new boolean[3];
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }

    public static double higher(double a, double b) {
        return (a - b) / b;
    }

    public static void calBai(double[] a, double b) {
        for (double v : a) {
            System.out.println(v / b * 100);
        }
    }
}
