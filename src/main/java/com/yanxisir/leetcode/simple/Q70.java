package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q70 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
        return solution3(n);
    }

    // 暴力解法（时间复杂度：O(2的n次方)，空间复杂度O(n)）
    protected int solution1(int n) {
        return climbStairs(0, n);
    }

    private int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    // 记忆化递归： 时间复杂度O(n), 空间复杂度O(n)
    protected int solution2(int n) {
        int memo[] = new int[n + 1];
        return climbStairsMemo(0, n, memo);
    }

    private int climbStairsMemo(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairsMemo(i + 1, n, memo) + climbStairsMemo(i + 2, n, memo);
        return memo[i];
    }

    // 动态规划: 时间复杂度O(n), 空间复杂度O(n)
    protected int solution3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
