/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

    /**
     * my own solution
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        //convert to max sub-array question
        int[] profits = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }
        //max sub-array
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < profits.length; i++) {
            localMax = Math.max(localMax + profits[i], profits[i]);
            if (localMax > globalMax)
                globalMax = localMax;
        }

        if (globalMax > 0) 
            ans = globalMax;
        return ans;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }
}