package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.List;

/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Tag("股票")
@DynamicPrograming
public class Q309 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] prices = (int[]) args[0];
        return solution1(prices);
    }

    protected int solution1(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][3];
        // 不持股没卖出
        dp[0][0] = 0;
        // 不持股卖出
        dp[0][1] = 0;
        // 持股
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q714.class);
    }
}
