package interview.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        ArrayList<Integer> pools = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int size = sc.nextInt();
            for (int j = 0; j < num; j++) {
                pools.add(size);
            }
        }
        int M = sc.nextInt();
        int[] requestMem = new int[M];
        for (int i = 0; i < M; i++) {
            requestMem[i] = sc.nextInt();
        }
        int[][] dp = new int[pools.size()][10];
        for (int i = 0; i < M; i++) {
            int block = requestMem[i];
            for (int j = 0; j < pools.size(); j++) {

            }
        }

        System.out.println(-1);
    }

}
