package leetcode.sword2;

public class _05_maxProduct {
//    给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
//    它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
//    2 <= words.length <= 1000
//    1 <= words[i].length <= 1000
//    words[i] 仅包含小写字母

    public int maxProduct(String[] words) {
        int size = words.length;
        if (size == 1) {
            return 0;
        }
        int[] bitWords = new int[size];
        int res = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int dif = words[i].charAt(j) - 'a';
                bitWords[i] |= 1 << dif;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((bitWords[i] & bitWords[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}
