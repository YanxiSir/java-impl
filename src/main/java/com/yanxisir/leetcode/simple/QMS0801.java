package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 面试题 08.01. 三步问题
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 *
 * @author: YanxiSir
 * @date: 2020/5/2
 * @sign: help yourself
 */
@Tag({"动态规划", "爬楼梯问题"})
public class QMS0801 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
        return solution1(n);
    }

    // 动态规划
    protected int solution1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007L;
        }
        return (int) dp[n];
    }
}
