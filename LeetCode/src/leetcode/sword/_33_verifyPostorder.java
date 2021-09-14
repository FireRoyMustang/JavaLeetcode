package leetcode.sword;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
public class _33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int mid = right - 1;
        for (; mid >= left; mid--) {
            if (postorder[mid] < postorder[right]) {
                break;
            }
        }
        for (int i = mid; i >= right; i--) {
            if (postorder[mid] > postorder[right]) {
                return false;
            }
        }
        return verifyPostorder(postorder, left, mid) && verifyPostorder(postorder, mid + 1, right - 1);
    }
}
