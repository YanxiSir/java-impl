package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author: YanxiSir
 * @Date: 2020/4/28
 * @Sign: 心中田间，木行水上
 */
@Tag("动态规划")
@DynamicPrograming
public class Q279 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
        return solution1(n);
    }

    // 动态规划
    protected int solution1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
