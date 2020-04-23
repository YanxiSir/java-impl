package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag({"堆排"})
@Deprecated
public class Q347 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        int k = (int) args[1];
        return solution1(nums, k);
    }

    protected int[] solution1(int[] nums, int k) {
        return nums;
    }
}
