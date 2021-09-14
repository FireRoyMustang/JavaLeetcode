package interview.iqiyi;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        String next;
        next = sc.next();
        while (!"]".equals(next = sc.next())) {
            String[] elements = next.split(",");
            list.add(new int[]{
                    Integer.parseInt(elements[0].substring(1)), Integer.parseInt(elements[1].substring(0, elements[1].length() - 1))});
        }
        int ans = 0;
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        if (list.size() <= 1) {
            System.out.println(0);
            return;
        } else {
            int[] ints = list.get(0);
            int start = ints[0];
            int end = ints[1];
            for (int i = 1; i < list.size(); i++) {
                ints = list.get(i);
                if (ints[0] < end) {
                    ans++;
                } else if (ints[1] <= end) {
                    ans++;
                } else {
                    start = ints[0];
                    end = ints[1];
                }
            }
        }

        System.out.println(ans);
    }
}
