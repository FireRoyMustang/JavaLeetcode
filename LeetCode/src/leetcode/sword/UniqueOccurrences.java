package leetcode.sword;

import java.util.HashMap;
import java.util.HashSet;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/10/28 8:56
 *@Version V1.0
 **/
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 0);
            }
        }
        return map.values().size()==new HashSet<Integer>(map.values()).size();
    }
}
