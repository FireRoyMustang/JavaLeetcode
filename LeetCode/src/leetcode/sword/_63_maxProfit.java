package leetcode.sword;

//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
public class _63_maxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return res;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(prices[i] - min, res);
            }
        }
        return res;
    }
}
