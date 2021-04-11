package leetcode;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/21 9:59
 *@Version V1.0
 **/
public class IsLongPressedName {
    public static void main(String[] args) {
        IsLongPressedName i = new IsLongPressedName();
//        i.isLongPressedName("alex", "aaleex");
//        System.out.println(i.isLongPressedName("aseed", "ssaaedd"));
        System.out.println(i.isLongPressedName("leelee", "lleeelee"));
        System.out.println(i.isLongPressedName("pyplrz", "ppyypllr"));
    }

    public boolean isLongPressedName(String name, String typed) {
        int len = name.length();
        int typedLen = typed.length();
        if (len == 0 || typedLen < len)
            return false;
        int namePt = 0;
        int counter;
        int typedPt = 0;
        char prevC;
        while (namePt < len && typedPt < typedLen) {
            prevC = name.charAt(namePt++);
            counter = 1;
            while (namePt < len && name.charAt(namePt) == prevC) {
                counter++;
                namePt++;
            }
            while (counter > 0 && typedPt < typedLen) {
                if (typed.charAt(typedPt) != prevC)
                    return false;
                typedPt++;
                counter--;
            }
            if (counter > 0)
                return false;
            while (typedPt < typedLen && typed.charAt(typedPt) == prevC)
                typedPt++;
        }
        return typedPt == typedLen && namePt == len;
    }
}
