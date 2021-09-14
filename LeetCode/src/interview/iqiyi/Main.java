package interview.iqiyi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        String[] orders = next.substring(1, next.length() - 1).split(",");
        FooPrint foo = new FooPrint();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
        for (int i = 0; i < orders.length; i++) {
            threads.get(Integer.parseInt(orders[i]) - 1).start();
        }
        reader.close();
    }
}

class FooPrint {
    private static boolean flag1;
    private static boolean flag2;

    public FooPrint() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        //待实现
        printFirst.run();
        flag1 = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //待实现
        while (!flag1) {
        }
        printSecond.run();
        flag2 = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        //待实现
        while (!flag2) {
        }
        printThird.run();
        flag2 = false;
        flag1 = false;
    }
}
