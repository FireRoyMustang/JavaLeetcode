package leetcode.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/20 8:10
 *@Version V1.0
 **/
public class _1239_maxLength {
    public static void main(String[] args) {
        _1239_maxLength m = new _1239_maxLength();
        System.out.println(m.maxLength(Arrays.asList(new String[]{"un", "iq", "ue"})));
        System.out.println(m.maxLength(Arrays.asList(new String[]{"cha", "r", "act", "ers"})));
        System.out.println(m.maxLength(Arrays.asList(new String[]{"abcdefghijklmnopqrstuvwxyz"})));
    }

    //    给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
//    如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
//    请返回所有可行解 s 中最长长度。
//    1 <= arr.length <= 16
//    1 <= arr[i].length <= 26
//    arr[i] 中只含有小写英文字母
    public int maxLength(List<String> arr) {
        int size = arr.size();
        if (size == 0) {
            return 0;
        }
        int[] records = new int[26];
        return backTrace(arr, 0, records, 0);
    }

    public int backTrace(List<String> arr, int index, int[] records, int length) {
        if (index == arr.size()) {
            return length;
        }
        int[] recordsCopy = Arrays.copyOf(records, 26);
        String str = arr.get(index);
        int trace1 = 0, trace2 = 0;
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int diff = c - 'a';
            if (records[diff] == 1) {
                flag = true;
                break;
            } else {
                records[diff]++;
                count++;
            }
        }
        // 不重复
        if (!flag) {
            trace1 = backTrace(arr, index + 1, records, length + count);
        }
        // 不选择
        trace2 = backTrace(arr, index + 1, recordsCopy, length);
        return Math.max(trace1, trace2);
    }
}
