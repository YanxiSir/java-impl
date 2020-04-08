package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Deprecated
public class Q714 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] prices = (int[]) args[0];
        int fee = (int) args[1];
        return solution1(prices, fee);
    }

    protected int solution1(int[] prices, int fee) {
        return 0;
    }
}
