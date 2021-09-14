package test;

import java.util.HashMap;
import java.util.Set;

/**
 * @Description
 * @Author ShenYubo
 * @Date 2021/5/5 23:19
 * @Version V1.0
 **/
public class TestMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        Integer integer = map.get(1);
        integer += 1;
        System.out.println(map.get(1));
        Set<Integer> keySet = map.keySet();
        System.out.println(keySet.size());
        map.clear();
        System.out.println(keySet.size());
    }
}
