package com.yanxisir.leetcode.hard;

import com.yanxisir.leetcode.AbstractQ;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author: YanxiSir
 * @Date: 2020/4/12
 * @Sign: 心中田间，木行水上
 */
@Deprecated
public class Q128 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        int max = 1;
        for (Integer num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int number = num + 1;
            int stackLen = 1;
            while (set.contains(number)) {
                number++;
                stackLen++;
            }
            max = Math.max(max, stackLen);
        }
        return max;
    }
}
