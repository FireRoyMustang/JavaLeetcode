package leetcode.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/27 7:39
 *@Version V1.0
 **/
public class _909_snakesAndLadders {

    public static void main(String[] args) {
        _909_snakesAndLadders s = new _909_snakesAndLadders();
//        s.test(5);
//        s.test(6);
        System.out.println(s.snakesAndLadders(new int[][]{
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 35, -1, -1, 13, -1},
                new int[]{1, -1, -1, -1, -1, -1},
                new int[]{-1, 15, -1, -1, -1, -1},
        }));
        System.out.println(s.snakesAndLadders(new int[][]{
                new int[]{-1, -1},
                new int[]{-1, 3},
        }));
        System.out.println(s.snakesAndLadders(new int[][]{
                new int[]{-1, -1, 19, 10, -1},
                new int[]{2, -1, -1, 6, -1},
                new int[]{-1, 17, -1, 19, -1},
                new int[]{25, -1, 20, -1, -1},
                new int[]{-1, -1, -1, -1, 15},
        }));
        System.out.println(s.snakesAndLadders(new int[][]{
                new int[]{-1, 10, -1, 15, -1},
                new int[]{-1, -1, 18, 2, 20},
                new int[]{-1, -1, 12, -1, -1},
                new int[]{2, 4, 11, 18, 8},
                new int[]{-1, -1, -1, -1, -1},
        }));
        System.out.println(s.snakesAndLadders(new int[][]{
                new int[]{-1, -1, -1, 46, 47, -1, -1, -1},
                new int[]{51, -1, -1, 63, -1, 31, 21, -1},
                new int[]{-1, -1, 26, -1, -1, 38, -1, -1},
                new int[]{-1, -1, 11, -1, 14, 23, 56, 57},
                new int[]{11, -1, -1, -1, 49, 36, -1, 48},
                new int[]{-1, -1, -1, 33, 56, -1, 57, 21},
                new int[]{-1, -1, -1, -1, -1, -1, 2, -1},
                new int[]{-1, -1, -1, 8, 3, -1, 6, 56},
        }));
    }


//    N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
//    r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，
//    那个蛇或梯子的目的地将会是 board[r][c]。
//    玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
//    每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
//    选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
//    该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
//    传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。 

//    注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
//
//    返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。

//    2 <= board.length = board[0].length <= 20
//    board[i][j] 介于 1 和 N*N 之间或者等于 -1。
//    编号为 1 的方格上没有蛇或梯子。
//    编号为 N*N 的方格上没有蛇或梯子。


    public int snakesAndLadders(int[][] board) {
        int slides = board.length;
        int target = slides * slides;
        int steps = 0;
        boolean flag = slides % 2 == 1;
        HashSet<Integer> visted = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int x = slides - cur / slides - 1;
                int y = cur % slides;
                boolean flag2 = flag ^ (x % 2 == 1); // 方向为正
                if (!flag2) {
                    y = slides - y - 1;
                }
                for (int j = 0; j < 6; j++) {
                    cur++;
                    y += flag2 ? 1 : -1;
                    if (y == slides) {
                        x -= 1;
                        y = slides - 1;
                        flag2 = !flag2;
                    }
                    if (y == -1) {
                        x -= 1;
                        y = 0;
                        flag2 = !flag2;
                    }
                    if (board[x][y] == target || cur == target - 1) {
                        return steps;
                    }
                    if (!visted.contains(cur)) {
                        if (board[x][y] != -1 && !visted.contains(board[x][y] - 1)) {
                            queue.offer(board[x][y] - 1);
                        } else {
                            queue.offer(cur);
                        }
                    }
                    visted.add(cur);
                }

            }
        }
        return -1;
    }

    public void test(int slides) {
        boolean flag = slides % 2 == 1;
        for (int cur = 0; cur < slides * slides; cur++) {
            int x = slides - cur / slides - 1;
            int y = cur % slides;
            boolean flag2 = !(flag ^ (x % 2 == 1));
            if (flag2) {
                y = slides - y - 1;
            }
            System.out.println("x:" + x + ", y:" + y);
        }

    }


}
