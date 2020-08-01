package com.book.mall.leetcode.array;

/**
 * ClassName: BestTimeToBuyAndSellStock
 * Description:
 * 121. 买卖股票的最佳时机
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * date: 2020/8/2 12:53 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] prices = new int[] {7,1,5,3,6,4};
        int[] prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    /**
     * 1.两层循环遍历，时间复杂度n^2
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int result = 0;
        for (int s = 0; s < prices.length; s++) {
            for (int p = s+1; p < prices.length; p++) {
                if (prices[p] > prices[s] && prices[p] - prices[s] > result) {
                    result = prices[p] - prices[s];
                }
            }
        }
        return result;
    }
}
