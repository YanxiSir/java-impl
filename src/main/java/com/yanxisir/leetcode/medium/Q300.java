package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author: YanxiSir
 * @Date: 2020/4/27
 * @Sign: 心中田间，木行水上
 */
@DynamicPrograming
@Tag({"贪心", "二分", "动态规划"})
public class Q300 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 动态规划
    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int subMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    subMax = Math.max(subMax, dp[j]);
                }
            }
            dp[i] = subMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 贪心 + 二分查找
    protected int solution2(int[] nums) {
        return 0;
    }
}
