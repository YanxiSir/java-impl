package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@DynamicPrograming
public class Q62 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int m = (int) args[0];
        int n = (int) args[1];
        return solution1(m, n);
    }

    // 动态规划
    protected int solution1(int m, int n) {
        // dp[i][j]记录每一格可能情况
        // dp[m][n] = dp[m-1][n] + dp[m][n-1]

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
