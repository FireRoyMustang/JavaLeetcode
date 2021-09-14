package interview.iqiyi;

import java.util.*;

//求1 到 n 的每个整数 10 进制表示下的数位和，把数位和相等的数字放到同一个组中。统计每个组中的数字数目，并返回数字数目并列最多的组有多少个
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = countDigitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        ArrayList<Integer> digits = new ArrayList<>(map.values());
        Collections.sort(digits, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ans++;
        int tmp = digits.get(0);
        for (int i = 1; i < digits.size(); i++) {
            if (tmp != digits.get(i)) {
                break;
            }
            tmp = digits.get(i);
            ans++;
        }
        System.out.println(ans);
    }

    public static int countDigitSum(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
