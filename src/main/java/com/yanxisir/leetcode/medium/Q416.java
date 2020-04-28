package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.Arrays;

/**
 * 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Remember
@DynamicPrograming
@Tag({"01"})
public class Q416 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 动态规划-无空间优化
    protected boolean solution1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // 商品个数，背包大小。 能否正好装满
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }

            }
        }
        return dp[nums.length][target];
    }

    // 动态规划-空间优化
    protected boolean solution2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // 商品个数，背包大小。 能否正好装满
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }

            }
        }
        return dp[target];
    }
}
