package interview.monkey;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pre = 0, first = 0, second = 0, count = 0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            count++;
            int num = in.nextInt();
            if (num < pre) {
                if (first == 0) {
                    first = count - 1;
                } else {
                    second = count;
                }
            }
            pre = num;
        }
        if (second == 0) {
            second = first;
            first = 0;
        }
        System.out.printf("%d %d", first, second);
    }

}
