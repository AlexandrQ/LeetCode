package main.easy;

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    Example 2:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104
*/

public class _121_BestTimeToBuyAndSelLStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = 1000000;
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] >= min || (i < prices.length - 1 && prices[i] >= prices[i + 1])) {
                continue;
            } else {
                min = prices[i];
            }

            max = 0;
            for(int j = i + 1; j < prices.length; j++) {

                if(prices[j] < prices[i] || prices[j] <= max) {
                    continue;
                } else {
                    max = prices[j];
                }

                int profit = prices[j] - prices[i];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}

/*
    Runtime: 7 ms, faster than 6.93% of Java online submissions for Best Time to Buy and Sell Stock.
    Memory Usage: 52 MB, less than 80.60% of Java online submissions for Best Time to Buy and Sell Stock.
*/
