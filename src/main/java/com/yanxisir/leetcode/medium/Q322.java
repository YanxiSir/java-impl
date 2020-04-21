package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/description/
 * <p>
 * <p>
 * 这种找路径，找方法的题一般可以使用回溯法来解决，回溯法也可以说是树形图法，解题的时候使用类似于树状图的结构，使用 自顶而下 的方法。
 * 而在回溯法中，如果含有很多的重复的计算的时候，就可以使用记忆化的搜索，将可能出现的重复计算大状态使用一个数组来保存其值，在进行重复的计算的时候，就可以直接的调用数组中的值，较少了不必要的递归。
 * 使用了记忆化搜索后，一般还可以进行优化，在记忆化搜索的基础上，变成 自底而上 的动态规划。
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@Remember
public class Q322 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] coins = (int[]) args[0];
        int amount = (int) args[1];
        return solution1(coins, amount);
    }

    int res1 = Integer.MAX_VALUE;

    // 递归
    protected int solution1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        findWay(coins, amount, 0);
        return res1 == Integer.MAX_VALUE ? -1 : res1;
    }

    private void findWay(int[] coins, int leftAmount, int count) {
        if (leftAmount < 0) {
            return;
        }
        if (leftAmount == 0) {
            res1 = Math.min(res1, count);
        }
        for (int i = 0; i < coins.length; i++) {
            findWay(coins, leftAmount - coins[i], count + 1);
        }
    }


    int[] memo;

    // 记忆化搜索
    protected int solution2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];
        return findWay2(coins, amount);
    }

    protected int findWay2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay2(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }

    // 动态规划
    protected int solution3(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        return 0;
    }
}
