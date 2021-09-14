package leetcode.algorithm;

import java.util.*;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/25 10:50
 *@Version V1.0
 **/
public class _752_openLock {


    public static void main(String[] args) {
        _752_openLock o = new _752_openLock();
        System.out.println(o.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"},
                "0202"));
        System.out.println(o.openLock(new String[]{}, "0000"));
        System.out.println(o.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
                "8888"));
        System.out.println(o.openLock(new String[]{"8888"}, "0009"));
    }
//    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：
//    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
//    每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//    字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。

    Set<String> deadEnds = new HashSet<>();
    Set<String> visited = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        for (String deadend : deadends) {
            deadEnds.add(deadend);
        }
        if (deadEnds.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        int steps = 0;
        StringBuilder lockState = new StringBuilder();
        lockState.append("0000");
        LinkedList<StringBuilder> queue = new LinkedList<>();
        queue.add(lockState);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder sb = queue.poll();
                ArrayList<StringBuilder> stringBuilders = moveLock(sb);
                for (StringBuilder stringBuilder : stringBuilders) {
                    String lock = stringBuilder.toString();
                    if (lock.equals(target)) {
                        return steps;
                    } else {
                        visited.add(lock);
                        queue.offer(stringBuilder);
                    }
                }
            }
        }
        return -1;
    }

    private ArrayList<StringBuilder> moveLock(StringBuilder sb) {
        ArrayList<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = sb.charAt(i);
            StringBuilder lock1 = getLock(sb, i, c, true);
            StringBuilder lock2 = getLock(sb, i, c, false);
            if (lock1 != null) {
                res.add(lock1);
            }
            if (lock2 != null) {
                res.add(lock2);
            }
        }
        return res;
    }

    private StringBuilder getLock(StringBuilder sb, int index, char c, boolean up) {
        StringBuilder res = new StringBuilder(sb);
        if (up) {
            if (c == '0') {
                res.setCharAt(index, '9');
            } else {
                c -= 1;
                res.setCharAt(index, c);
            }
        } else {
            if (c == '9') {
                res.setCharAt(index, '0');
            } else {
                c += 1;
                res.setCharAt(index, c);
            }
        }
        String lock = res.toString();
        if (deadEnds.contains(lock) || visited.contains(lock)) {
            return null;
        }
        return res;
    }


}
