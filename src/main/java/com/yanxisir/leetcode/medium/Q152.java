package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;

/**
 * 乘积最大子序和
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
@DynamicPrograming
public class Q152 extends AbstractQ {
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
        if (nums.length == 1) {
            return nums[0];
        }
        int maxP = nums[0];
        int minP = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = maxP;
            maxP = Math.max(Math.max(maxP * nums[i], nums[i]), minP * nums[i]);
            minP = Math.min(Math.min(t * nums[i], nums[i]), minP * nums[i]);
            max = Math.max(maxP, max);
        }
        return max;
    }
}
