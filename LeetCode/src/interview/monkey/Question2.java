package interview.monkey;

import java.util.Scanner;

public class Question2 {
    //    [][][[[]3[]2]2]2
    //    [][[][][]2]3
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

}
