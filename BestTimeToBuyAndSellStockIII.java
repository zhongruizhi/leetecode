/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

public class BestTimeToBuyAndSellStockIII {

    /**
     * https://interview.hackingnote.com/en/problems/best-time-to-buy-and-sell-stock-iii
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0,
                buy2 = Integer.MIN_VALUE, sell2 = 0;

        for (int price : prices) {
            sell2 = Math.max(sell2, price + buy2);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, price + buy1);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }


    /**
     * https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
     
        //highest profit in 0 ... i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
     
        // DP from left to right
        left[0] = 0; 
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
     
        // DP from right to left
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
     
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
     
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit2(prices));
    }
}