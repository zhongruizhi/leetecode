/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * https://medium.com/algorithms-and-leetcode/best-time-to-buy-sell-stocks-on-leetcode-the-ultimate-guide-ce420259b323
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * https://twchen.gitbook.io/leetcode/dynamic-programming/best-time-to-buy-and-sell-stock-with-cooldown
     * https://www.cnblogs.com/grandyang/p/4997417.html
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy = 0, sell = 0, preSell = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }

    /**
     * 
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length < 2)
            return 0;
        //max profit at day i with holding stock
        int[] hold = new int[prices.length];
        //max profit at day i without holding stock
        int[] sell = new int[prices.length];
        hold[0] = -prices[0];
        sell[0] = 0;
        for (int i = 2; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], sell[i - 2]  - prices[i]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit2(prices));
    }

}