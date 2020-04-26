package com.yanxisir.leetcode.simple;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.medium.Q714;
import com.yanxisir.leetcode.zannos.Remember;

import java.util.List;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q121 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    protected int solution1(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mini) {
                mini = nums[i];
            }
            if (nums[i] - mini > maxProfit) {
                maxProfit = nums[i] - mini;
            }
        }
        return maxProfit;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q122.class, Q714.class);
    }
}
