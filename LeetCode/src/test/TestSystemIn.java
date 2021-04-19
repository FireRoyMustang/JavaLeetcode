package test;

import java.util.Scanner;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/18 12:54
 *@Version V1.0
 **/
public class TestSystemIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
        System.out.println(sc.nextLine());//此时输入1只会读到换行符

    }
}
