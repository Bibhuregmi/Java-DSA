package Leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1377804101/?envType=problem-list-v2&envId=dynamic-programming
public class buyandsellstocks {

    public static void main(String[] args) {
        int prices[] = { 2, 1, 4 };
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

}

/*
 * The goal is to find the maximum profit from a single buy-sell transaction.
 * 
 * Approach:
 * - Initialize 'minPrice' to the maximum possible integer value.
 * - Initialize 'maxProfit' to 0.
 * - Iterate through the prices:
 * - Update 'minPrice' if the current price is lower than the current
 * 'minPrice'.
 * - Calculate the profit by subtracting 'minPrice' from the current price.
 * - Update 'maxProfit' if the calculated profit is higher than the current
 * 'maxProfit'.
 * 
 * This approach ensures that we always buy at the lowest price seen so far and
 * sell at the current price to maximize profit.
 */