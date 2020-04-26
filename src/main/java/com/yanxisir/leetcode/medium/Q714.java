package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Tag("股票")
@DynamicPrograming
public class Q714 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] prices = (int[]) args[0];
        int fee = (int) args[1];
        return solution1(prices, fee);
    }

    protected int solution1(int[] prices, int fee) {

        int noHold = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i] - fee);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }
}
