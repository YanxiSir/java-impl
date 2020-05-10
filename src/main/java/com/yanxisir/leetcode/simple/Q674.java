package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author: YanxiSir
 * @date: 2020/5/10
 * @sign: help yourself
 */
public class Q674 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int curMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curMax++;
                max = Math.max(max, curMax);
            } else {
                curMax = 1;
            }
        }
        return max;
    }
}
