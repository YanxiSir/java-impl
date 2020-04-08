package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@DynamicPrograming
public class Q198 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    protected int solution1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    protected int solution2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int pre = 0, cur = 0;
        for (int n : nums) {
            int tmp = cur;
            cur = Math.max(cur, pre + n);
            pre = tmp;
        }
        return cur;
    }
}
