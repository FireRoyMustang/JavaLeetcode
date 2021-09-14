package leetcode.sword;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
//你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//1 <= n <= 11
public class _60_dicesProbability {
    public static void main(String[] args) {
        double i = 1 / 6;
        System.out.println(i);
    }

    private final double[] PROB = {1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6};

    public double[] dicesProbability(int n) {
        if (n == 1) {
            return PROB;
        }
        double[] res = new double[5 * n + 1];
        double[] lastProb = dicesProbability(n - 1);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < lastProb.length; j++) {
                res[i + j] += lastProb[j] / 6;
            }
        }
        return res;
    }
}
