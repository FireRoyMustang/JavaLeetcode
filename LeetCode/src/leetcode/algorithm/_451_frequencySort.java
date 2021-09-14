package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class _451_frequencySort {
    public static void main(String[] args) {
        _451_frequencySort f = new _451_frequencySort();
        System.out.println(f.frequencySort("tree"));
    }

//    给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> characters = new ArrayList<>(map.keySet());
        Collections.sort(characters, (c1, c2) -> -Integer.compare(map.get(c1), map.get(c2)));
        for (Character c : characters) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
