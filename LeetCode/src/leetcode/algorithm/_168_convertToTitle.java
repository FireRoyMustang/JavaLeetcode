package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/29 11:48
 *@Version V1.0
 **/
public class _168_convertToTitle {
    public static void main(String[] args) {
        _168_convertToTitle c = new _168_convertToTitle();
        for (int i = 26; i < 26 * 27; i++) {
            System.out.println(c.convertToTitle(i));
        }
//        System.out.println(c.convertToTitle(52));
    }
//    给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//    例如：
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        while (columnNumber > 0) {
            columnNumber--;
            remain = columnNumber % 26;
            columnNumber /= 26;
            sb.insert(0, (char) (remain + 'A'));

        }
        return sb.toString();
    }

}
