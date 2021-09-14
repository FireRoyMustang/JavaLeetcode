package leetcode;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2020/10/19 9:33
 * @Version V1.0
 **/
public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare b = new BackspaceCompare();
        boolean b1 = b.backspaceCompare("bxj##tw", "bxo#j##tw");
        System.out.println(b1);
    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;

//        int sPt = S.length() - 1;
//        int tPt = T.length() - 1;
//        int sBackNum = 0;
//        int tBackNum = 0;
//        while (sPt >= 0 || tPt >= 0) {
//            while (sPt >= 0 && S.charAt(sPt) == '#') {
//                sPt--;
//                sBackNum++;
//            }
//            while (sBackNum > 0) {
//                sPt--;
//                sBackNum--;
//            }
//            while (tPt >= 0 && T.charAt(tPt) == '#') {
//                tPt--;
//                tBackNum++;
//            }
//            while (tBackNum > 0) {
//                tPt--;
//                tBackNum--;
//            }
//            if (sPt >= 0 && tPt >= 0) {
//                if (S.charAt(sPt) != T.charAt(tPt))
//                    return false;
//                else {
//                    sPt--;
//                    tPt--;
//                }
//            }
//        }
//        return true;

    }
}
