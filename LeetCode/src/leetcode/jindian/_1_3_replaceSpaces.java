package leetcode.jindian;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/11 11:12
 *@Version V1.0
 **/


public class _1_3_replaceSpaces {
    //    URL化。编写一种方法，将字符串中的空格全部替换为%20。
//    假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
//    （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    public static void main(String[] args) {
        System.out.println("ds sdfs afs sdfa dfssf asdf             ".length());
        System.out.println(new _1_3_replaceSpaces().replaceSpaces(
                "ds sdfs afs sdfa dfssf asdf             "
                , 27));
    }

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int ptr = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != ' ') {
                chars[ptr++] = S.charAt(i);
            } else {
                chars[ptr++] = '%';
                chars[ptr++] = '2';
                chars[ptr++] = '0';
            }
        }
        return new String(chars,0,ptr);
    }
//    public String replaceSpaces(String S, int length) {
//        //先把字符串转化为字符数组
//        char[] chars = S.toCharArray();
//        int index = chars.length - 1;
//        for (int i = length - 1; i >= 0; i--) {
//            //如果遇到空格就把他转化为"%20"
//            if (chars[i] == ' ') {
//                chars[index--] = '0';
//                chars[index--] = '2';
//                chars[index--] = '%';
//            } else {
//                chars[index--] = chars[i];
//            }
//        }
//        return new String(chars, index + 1, chars.length - index - 1);
//    }
}
