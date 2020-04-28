package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@DynamicPrograming
public class Q518 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int amount = (int) args[0];
        int[] coins = (int[]) args[1];
        return solution1(amount, coins);
    }

    protected int solution1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 不选硬币i
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    // 选硬币i，完全背包问题，i还能继续用
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }

    protected int solution2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return 0;
    }


}
