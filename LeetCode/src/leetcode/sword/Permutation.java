package leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/3 9:47
 *@Version V1.0
 **/
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class Permutation {

    public static void main(String[] args) {
        new Permutation().Permutation("aabcdefg");
    }

    //1、从右向左找到第一个正序对（array[i] < array[i+1]，因为没有等号，所以可以完美去掉重复的排列）
    //2、从i开始向右搜索，找到比array[i]大的字符中最小的那个，记为array[j]
    //3、交换array[i]和array[j]
    //4、将i后面的字符反转
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(str);
        while (true) {
            s = nextString(s);
            if (!s.equals("finish")) {
                res.add(s);
            } else {
                break;
            }
        }
        return res;
    }

    public String nextString(String str) {
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for (; i >= 0 && array[i] >= array[i + 1]; i--) ;
        if (i == -1) return "finish";
        int j = length - 1;
        for (; j >= 0 && array[j] <= array[i]; j--) ;
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for (int a = i + 1, b = length - 1; a < b; a++, b--) {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }
}
