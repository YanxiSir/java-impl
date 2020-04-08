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

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q123.class, Q309.class, Q714.class);
    }
}
