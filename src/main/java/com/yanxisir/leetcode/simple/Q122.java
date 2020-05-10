package com.yanxisir.leetcode.simple;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.hard.Q123;
import com.yanxisir.leetcode.medium.Q309;
import com.yanxisir.leetcode.medium.Q714;
import com.yanxisir.leetcode.zannos.Greedy;
import com.yanxisir.leetcode.zannos.Remember;

import java.util.List;

/**
 * 买卖股票的最佳时机II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Greedy
@Remember
public class Q122 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    protected int solution1(int[] prices) {
        int len = prices.length;
        int ret = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }

    // dp
    protected int solution2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 0-不持有；1-持有
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    // dp - 考虑状态压缩
    protected int solution3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 0-不持有；1-持有
        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q123.class, Q309.class, Q714.class);
    }
}
