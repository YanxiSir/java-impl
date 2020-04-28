package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 目标和
 * https://leetcode-cn.com/problems/target-sum/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Tag({"01", "递归"})
@Deprecated
public class Q494 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        int S = (int) args[1];
        return solution1(nums, S);
    }


    int counts = 0;

    // 递归
    protected int solution1(int[] nums, int S) {
        helper(nums, S, 0, 0);
        return counts;
    }

    private void helper(int[] nums, int S, int len, int sum) {
        if (len == nums.length) {
            if (sum == S) {
                counts++;
            }
        } else {
            helper(nums, S, len + 1, sum - nums[len]);
            helper(nums, S, len + 1, sum + nums[len]);
        }
    }
}
