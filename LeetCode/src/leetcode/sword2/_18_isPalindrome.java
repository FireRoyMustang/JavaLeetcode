package leetcode.sword2;

public class _18_isPalindrome {
//    给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
//    本题中，将空字符串定义为有效的 回文串 。

    public static void main(String[] args) {
        _18_isPalindrome i = new _18_isPalindrome();
        System.out.println(i.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } else {
                char c1 = Character.toLowerCase(cLeft);
                char c2 = Character.toLowerCase(cRight);
                if (c1 != c2) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
