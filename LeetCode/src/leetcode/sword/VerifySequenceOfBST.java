package leetcode.sword;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/9/1 14:13
 * @Version V1.0
 **/
public class VerifySequenceOfBST {
    //    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//    如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helpVerify(sequence, 0, sequence.length - 1);

    }

    public boolean helpVerify(int[] sequence, int start, int root) {
        if (start >= root) return true;
        int key = sequence[root];
        int i = 0;
        // 找到左右子数的分界点
        for (i = start; i < root; i++) {
            if (sequence[i] > key)
                break;
        }
        // 在右子树中判断是否含有小于root的值，如果有返回false
        for (int j = i; j < root; j++) {
            if (sequence[j] < key)
                return false;
        }

        return helpVerify(sequence, start, i - 1) && helpVerify(sequence, i, root - 1);
    }


//    public boolean VerifySequenceOfBST(int[] sequence) {
//
//        return false;
//    }
//
//    public boolean VerifySequenceOfLeftBST(int[] sequence, int nodeVal) {
//        int len = sequence.length;
//        if (len <= 2) {
//            for (int i = 0; i < len; i++) {
//                if (sequence[i] > nodeVal)
//                    return false;
//            }
//            return true;
//        } else {
//            int index;
//            for (index = 0; index < len; index++) {
//                if (sequence[index] >= sequence[len - 1]) {
//                    break;
//                }
//            }
//            return VerifySequenceOfLeftBST(Arrays.copyOfRange(sequence, 0, index),
//                    sequence[len - 1]) && VerifySequenceOfRightBST(
//                    Arrays.copyOfRange(sequence, index, len - 1), sequence[len - 1]);
//        }
//
//    }
//
//    public boolean VerifySequenceOfRightBST(int[] sequence, int nodeVal) {
//        if (sequence.length <= 2) {
//            for (int i = 0; i < sequence.length; i++) {
//                if (sequence[i] < nodeVal)
//                    return false;
//            }
//            return true;
//        } else {
//            return false;
//        }
//
//    }
}
