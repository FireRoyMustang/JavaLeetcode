package interview.huawei;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int[] memoryNums = new int[N];
        int[] memorySizes = new int[N];
        for (int i = 0; i < N; i++) {
            memoryNums[i] = sc.nextInt();
            memorySizes[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {

        }
        System.out.println(ans);
    }
}
