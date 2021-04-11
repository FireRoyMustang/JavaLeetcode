package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/24 10:44
 *@Version V1.0
 **/
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(13));
    }

    public int findNthDigit(int n) {
        int start = 1;
        int digit = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit *= 10;
            start++;
            count = start * 9 * digit;
        }
        return Long.toString(digit + (n - 1) / start).charAt((n - 1) % start) - '0';
    }
}
