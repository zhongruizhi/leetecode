/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * https://wxx5433.gitbooks.io/interview-preparation/content/part_ii_leetcode_lintcode/dp/best_time_to_buy_and_sell_stock_iv.html
     * https://www.cnblogs.com/grandyang/p/4295761.html
     * 
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length < 2 || k < 1) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxProfitWithoutLimit(prices);
        }

        int[][] global = new int[prices.length][k + 1];
        int[][] local = new int[prices.length][k + 1];

        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for(int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[prices.length - 1][k];
    }

    private int maxProfitWithoutLimit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(2, prices));
    }
}