package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.simple.Q198;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;

import java.util.Arrays;
import java.util.List;

/**
 * 打家劫舍II
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
@DynamicPrograming
public class Q213 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution(nums);
    }

    protected int solution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    protected int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (Integer num : nums) {
            tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q198.class, Q337.class);
    }
}
